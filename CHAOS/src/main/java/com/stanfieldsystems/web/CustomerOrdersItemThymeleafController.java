package com.stanfieldsystems.web;
import com.stanfieldsystems.CustomerOrder;

import com.stanfieldsystems.service.api.CustomerOrderService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
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
 * = CustomerOrdersItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = CustomerOrder.class, type = ControllerType.ITEM)
//@RooThymeleaf
@Controller
@RequestMapping(value = "/customerorders/{customerOrder}", name = "CustomerOrdersItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CustomerOrdersItemThymeleafController {

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
     * @param messageSource
     */
    @Autowired
    public CustomerOrdersItemThymeleafController(CustomerOrderService customerOrderService, MessageSource messageSource) {
        this.customerOrderService = customerOrderService;
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
     * @param customerOrder
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute CustomerOrder customerOrder, Model model) {
        return new ModelAndView("customerorders/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @return UriComponents
     */
    public static UriComponents showURI(CustomerOrder customerOrder) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CustomerOrdersItemThymeleafController.class).show(customerOrder, null)).buildAndExpand(customerOrder.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("customerOrder")
    public void initCustomerOrderBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("orderDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
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
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute CustomerOrder customerOrder, Model model) {
        populateForm(model);
        return new ModelAndView("customerorders/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute CustomerOrder customerOrder, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("customerorders/edit");
        }
        CustomerOrder savedCustomerOrder = customerOrderService.save(customerOrder);
        UriComponents showURI = CustomerOrdersItemThymeleafController.showURI(savedCustomerOrder);
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute CustomerOrder customerOrder) {
        customerOrderService.delete(customerOrder);
        return ResponseEntity.ok().build();
    }
}
