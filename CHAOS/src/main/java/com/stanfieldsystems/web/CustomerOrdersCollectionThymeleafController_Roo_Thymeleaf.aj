// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stanfieldsystems.web;

import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.service.api.CustomerOrderService;
import com.stanfieldsystems.web.CustomerOrdersCollectionThymeleafController;
import com.stanfieldsystems.web.CustomerOrdersItemThymeleafController;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesData;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.data.web.select2.Select2Data;
import java.util.Locale;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

privileged aspect CustomerOrdersCollectionThymeleafController_Roo_Thymeleaf {
    
    declare @type: CustomerOrdersCollectionThymeleafController: @Controller;
    
    declare @type: CustomerOrdersCollectionThymeleafController: @RequestMapping(value = "/customerorders", name = "CustomerOrdersCollectionThymeleafController", produces = MediaType.TEXT_HTML_VALUE);
    
    /**
     * TODO Auto-generated attribute documentation
     */
    public MessageSource CustomerOrdersCollectionThymeleafController.messageSource;
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param customerOrderService
     * @param messageSource
     */
    @Autowired
    public CustomerOrdersCollectionThymeleafController.new(CustomerOrderService customerOrderService, MessageSource messageSource) {
        this.customerOrderService = customerOrderService;
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "list")
    @ResponseBody
    public ModelAndView CustomerOrdersCollectionThymeleafController.list(Model model) {
        return new ModelAndView("/customerorders/list");
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return UriComponents
     */
    public static UriComponents CustomerOrdersCollectionThymeleafController.listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(
                MvcUriComponentsBuilder.on(CustomerOrdersCollectionThymeleafController.class).list(null))
                .build().encode();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(produces = Datatables.MEDIA_TYPE, name = "datatables", value = "/dt")
    @ResponseBody
    public ResponseEntity<DatatablesData<CustomerOrder>> CustomerOrdersCollectionThymeleafController.datatables(GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<CustomerOrder> customerOrders = customerOrderService.findAll(search, pageable);
        long totalCustomerOrdersCount = customerOrders.getTotalElements();
        if (search != null && StringUtils.hasText(search.getText())) {
            totalCustomerOrdersCount = customerOrderService.count();
        }
        DatatablesData<CustomerOrder> datatablesData = new DatatablesData<CustomerOrder>(customerOrders, totalCustomerOrdersCount, draw);
        return  ResponseEntity.ok(datatablesData);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param search
     * @param pageable
     * @param locale
     * @return ResponseEntity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, name = "select2", value = "/s2")
    @ResponseBody
    public ResponseEntity<Select2Data<CustomerOrder>> CustomerOrdersCollectionThymeleafController.select2(GlobalSearch search, Pageable pageable, Locale locale) {
        Page<CustomerOrder> CustomerOrders = customerOrderService.findAll(search, pageable);
        String idExpression = "#{id}";
        String textExpression = messageSource.getMessage("expression_customerOrder", null, "#{toString()}", locale);
        Select2Data<CustomerOrder> select2Data = new Select2Data<CustomerOrder>(CustomerOrders, idExpression, textExpression);
        return  ResponseEntity.ok(select2Data);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param dataBinder
     */
    @InitBinder("customerOrder")
    public void CustomerOrdersCollectionThymeleafController.initCustomerOrderBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     */
    public void CustomerOrdersCollectionThymeleafController.populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("orderDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     */
    public void CustomerOrdersCollectionThymeleafController.populateForm(Model model) {
        populateFormats(model);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customerOrder
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView CustomerOrdersCollectionThymeleafController.create(@Valid @ModelAttribute CustomerOrder customerOrder, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            
            return new ModelAndView("/customerorders/create");
        }
        CustomerOrder newCustomerOrder = customerOrderService.save(customerOrder);
        UriComponents showURI = CustomerOrdersItemThymeleafController.showURI(newCustomerOrder);
        return new ModelAndView("redirect:" + showURI.toUriString());
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView CustomerOrdersCollectionThymeleafController.createForm(Model model) {
        populateForm(model);
        
        model.addAttribute(new CustomerOrder());
        return new ModelAndView("customerorders/create");
    }
    
}
