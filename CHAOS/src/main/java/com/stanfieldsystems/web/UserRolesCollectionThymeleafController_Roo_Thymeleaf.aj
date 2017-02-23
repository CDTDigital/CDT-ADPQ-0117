// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stanfieldsystems.web;

import com.stanfieldsystems.UserRole;
import com.stanfieldsystems.service.api.UserRoleService;
import com.stanfieldsystems.web.UserRolesCollectionThymeleafController;
import com.stanfieldsystems.web.UserRolesItemThymeleafController;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesData;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.data.web.select2.Select2Data;
import java.util.Locale;
import javax.validation.Valid;
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

privileged aspect UserRolesCollectionThymeleafController_Roo_Thymeleaf {
    
    declare @type: UserRolesCollectionThymeleafController: @Controller;
    
    declare @type: UserRolesCollectionThymeleafController: @RequestMapping(value = "/userroles", name = "UserRolesCollectionThymeleafController", produces = MediaType.TEXT_HTML_VALUE);
    
    /**
     * TODO Auto-generated attribute documentation
     */
    public MessageSource UserRolesCollectionThymeleafController.messageSource;
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param userRoleService
     * @param messageSource
     */
    @Autowired
    public UserRolesCollectionThymeleafController.new(UserRoleService userRoleService, MessageSource messageSource) {
        this.userRoleService = userRoleService;
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
    public ModelAndView UserRolesCollectionThymeleafController.list(Model model) {
        return new ModelAndView("/userroles/list");
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return UriComponents
     */
    public static UriComponents UserRolesCollectionThymeleafController.listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(
                MvcUriComponentsBuilder.on(UserRolesCollectionThymeleafController.class).list(null))
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
    public ResponseEntity<DatatablesData<UserRole>> UserRolesCollectionThymeleafController.datatables(GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<UserRole> userRoles = userRoleService.findAll(search, pageable);
        long totalUserRolesCount = userRoles.getTotalElements();
        if (search != null && StringUtils.hasText(search.getText())) {
            totalUserRolesCount = userRoleService.count();
        }
        
        for (UserRole userRole : userRoles) {
			System.out.println(userRole.getName());
		}
        
        DatatablesData<UserRole> datatablesData = new DatatablesData<UserRole>(userRoles, totalUserRolesCount, draw);
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
    public ResponseEntity<Select2Data<UserRole>> UserRolesCollectionThymeleafController.select2(GlobalSearch search, Pageable pageable, Locale locale) {
        Page<UserRole> UserRoles = userRoleService.findAll(search, pageable);
        String idExpression = "#{id}";
        String textExpression = messageSource.getMessage("expression_userRole", null, "#{getName()}", locale);
        Select2Data<UserRole> select2Data = new Select2Data<UserRole>(UserRoles, idExpression, textExpression);
        return  ResponseEntity.ok(select2Data);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param dataBinder
     */
    @InitBinder("userRole")
    public void UserRolesCollectionThymeleafController.initUserRoleBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     */
    public void UserRolesCollectionThymeleafController.populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     */
    public void UserRolesCollectionThymeleafController.populateForm(Model model) {
        populateFormats(model);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param userRole
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView UserRolesCollectionThymeleafController.create(@Valid @ModelAttribute UserRole userRole, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            
            return new ModelAndView("/userroles/create");
        }
        UserRole newUserRole = userRoleService.save(userRole);
        UriComponents showURI = UserRolesItemThymeleafController.showURI(newUserRole);
        return new ModelAndView("redirect:" + showURI.toUriString());
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView UserRolesCollectionThymeleafController.createForm(Model model) {
        populateForm(model);
        
        model.addAttribute(new UserRole());
        return new ModelAndView("userroles/create");
    }
    
}
