package com.stanfieldsystems.web;
import com.stanfieldsystems.UserInfo;

import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.service.api.CustomerOrderService;
import com.stanfieldsystems.service.api.UserInfoService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesData;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.joda.time.format.DateTimeFormat;
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
 * = UserInfoesItemCustomerOrdersThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = UserInfo.class, type = ControllerType.DETAIL)
//@RooDetail(relationField = "customerOrders")
//@RooThymeleaf
@Controller
@RequestMapping(value = "/userinfoes/{userInfo}/customerOrders", name = "UserInfoesItemCustomerOrdersThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class UserInfoesItemCustomerOrdersThymeleafController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public UserInfoService userInfoService;

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
     * @param userInfoService
     * @param customerOrderService
     * @param messageSource
     */
    @Autowired
    public UserInfoesItemCustomerOrdersThymeleafController(UserInfoService userInfoService, CustomerOrderService customerOrderService, MessageSource messageSource) {
        this.userInfoService = userInfoService;
        this.customerOrderService = customerOrderService;
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return UserInfo
     */
    @ModelAttribute
    public UserInfo getUserInfo(@PathVariable("userInfo") Long id) {
        UserInfo userInfo = userInfoService.findOne(id);
        if (userInfo == null) {
            throw new NotFoundException(String.format("UserInfo with identifier '%s' not found", id));
        }
        return userInfo;
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
     * @param userInfo
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<DatatablesData<CustomerOrder>> datatables(@ModelAttribute UserInfo userInfo, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<CustomerOrder> customerOrders = customerOrderService.findByUserInfo(userInfo, search, pageable);
        long totalCustomerOrdersCount = customerOrderService.countByUserInfo(userInfo);
        DatatablesData<CustomerOrder> data = new DatatablesData<CustomerOrder>(customerOrders, totalCustomerOrdersCount, draw);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param UserInfo
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute UserInfo UserInfo, Model model) {
        populateForm(model);
        model.addAttribute(new CustomerOrder());
        return new ModelAndView("userinfoes/customerOrders/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @param customerOrdersToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromCustomerOrders", value = "/{customerOrdersToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromCustomerOrders(@ModelAttribute UserInfo userInfo, @PathVariable("customerOrdersToRemove") Long customerOrdersToRemove) {
        userInfoService.removeFromCustomerOrders(userInfo, Collections.singleton(customerOrdersToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @param customerOrders
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute UserInfo userInfo, @RequestParam("customerOrdersIds") List<Long> customerOrders, Model model) {
        // Remove empty values
        for (Iterator<Long> iterator = customerOrders.iterator(); iterator.hasNext(); ) {
            if (iterator.next() == null) {
                iterator.remove();
            }
        }
        userInfoService.setCustomerOrders(userInfo, customerOrders);
        UriComponents listURI = UserInfoesCollectionThymeleafController.listURI();
        return new ModelAndView("redirect:" + listURI.toUriString());
    }
}
