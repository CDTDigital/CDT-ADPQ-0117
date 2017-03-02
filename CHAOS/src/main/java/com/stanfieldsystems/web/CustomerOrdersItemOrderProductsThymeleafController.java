package com.stanfieldsystems.web;
import com.stanfieldsystems.CustomerOrder;

import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.service.api.CustomerOrderService;
import com.stanfieldsystems.service.api.OrderProductService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesData;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

/**
 * = CustomerOrdersItemOrderProductsThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = CustomerOrder.class, type = ControllerType.DETAIL)
//@RooDetail(relationField = "orderProducts")
//@RooThymeleaf
@Controller
@RequestMapping(value = "/customerorders/{customerOrder}/orderProducts", name = "CustomerOrdersItemOrderProductsThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CustomerOrdersItemOrderProductsThymeleafController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public OrderProductService orderProductService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public CustomerOrderService customerOrderService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public MessageSource messageSource;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerOrderService
     * @param orderProductService
     * @param messageSource
     */
    @Autowired
    public CustomerOrdersItemOrderProductsThymeleafController(CustomerOrderService customerOrderService, OrderProductService orderProductService, MessageSource messageSource) {
        this.customerOrderService = customerOrderService;
        this.orderProductService = orderProductService;
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return CustomerOrder
     */
    @ModelAttribute
    public CustomerOrder getCustomerOrder(@PathVariable("customerOrder") Long id) {
        CustomerOrder customerOrder = customerOrderService.findOne(id);
        if (customerOrder == null) {
            throw new NotFoundException(String.format("CustomerOrder with identifier '%s' not found", id));
        }
        return customerOrder;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<DatatablesData<OrderProduct>> datatables(@ModelAttribute CustomerOrder customerOrder, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<OrderProduct> orderProducts = orderProductService.findByCustomerOrder(customerOrder, search, pageable);
        long totalOrderProductsCount = orderProductService.countByCustomerOrder(customerOrder);
        DatatablesData<OrderProduct> data = new DatatablesData<OrderProduct>(orderProducts, totalOrderProductsCount, draw);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param CustomerOrder
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute CustomerOrder CustomerOrder, Model model) {
        populateForm(model);
        model.addAttribute(new OrderProduct());
        return new ModelAndView("customerorders/orderProducts/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderProductsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromOrderProducts", value = "/{orderProductsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromOrderProducts(@ModelAttribute CustomerOrder customerOrder, @PathVariable("orderProductsToRemove") Long orderProductsToRemove) {
        customerOrderService.removeFromOrderProducts(customerOrder, Collections.singleton(orderProductsToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderProducts
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute CustomerOrder customerOrder, @RequestParam("orderProductsIds") List<Long> orderProducts, Model model) {
        // Remove empty values
        for (Iterator<Long> iterator = orderProducts.iterator(); iterator.hasNext(); ) {
            if (iterator.next() == null) {
                iterator.remove();
            }
        }
        customerOrderService.setOrderProducts(customerOrder, orderProducts);
        UriComponents listURI = CustomerOrdersCollectionThymeleafController.listURI();
        return new ModelAndView("redirect:" + listURI.toUriString());
    }
}
