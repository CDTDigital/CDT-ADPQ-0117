package com.stanfieldsystems.web;
import com.stanfieldsystems.OrderProduct;

import com.stanfieldsystems.service.api.OrderProductService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = OrderProductsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = OrderProduct.class, type = ControllerType.ITEM)
//@RooThymeleaf
@Controller
@RequestMapping(value = "/orderproducts/{orderProduct}", name = "OrderProductsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class OrderProductsItemThymeleafController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public OrderProductService orderProductService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public MessageSource messageSource;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderProductService
     * @param messageSource
     */
    @Autowired
    public OrderProductsItemThymeleafController(OrderProductService orderProductService, MessageSource messageSource) {
        this.orderProductService = orderProductService;
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return OrderProduct
     */
    @ModelAttribute
    public OrderProduct getOrderProduct(@PathVariable("orderProduct") Long id) {
        OrderProduct orderProduct = orderProductService.findOne(id);
        if (orderProduct == null) {
            throw new NotFoundException(String.format("OrderProduct with identifier '%s' not found", id));
        }
        return orderProduct;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProduct
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute OrderProduct orderProduct, Model model) {
        return new ModelAndView("orderproducts/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProduct
     * @return UriComponents
     */
    public static UriComponents showURI(OrderProduct orderProduct) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(OrderProductsItemThymeleafController.class).show(orderProduct, null)).buildAndExpand(orderProduct.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("orderProduct")
    public void initOrderProductBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
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
     * @param orderProduct
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute OrderProduct orderProduct, Model model) {
        populateForm(model);
        return new ModelAndView("orderproducts/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProduct
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute OrderProduct orderProduct, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("orderproducts/edit");
        }
        OrderProduct savedOrderProduct = orderProductService.save(orderProduct);
        UriComponents showURI = OrderProductsItemThymeleafController.showURI(savedOrderProduct);
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProduct
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute OrderProduct orderProduct) {
        orderProductService.delete(orderProduct);
        return ResponseEntity.ok().build();
    }
}
