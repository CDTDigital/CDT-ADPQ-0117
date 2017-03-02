package com.stanfieldsystems.web;
import com.stanfieldsystems.UserRole;

import com.stanfieldsystems.service.api.UserRoleService;
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
 * = UserRolesItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = UserRole.class, type = ControllerType.ITEM)
//@RooThymeleaf
@Controller
@RequestMapping(value = "/userroles/{userRole}", name = "UserRolesItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class UserRolesItemThymeleafController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public UserRoleService userRoleService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public MessageSource messageSource;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param userRoleService
     * @param messageSource
     */
    @Autowired
    public UserRolesItemThymeleafController(UserRoleService userRoleService, MessageSource messageSource) {
        this.userRoleService = userRoleService;
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return UserRole
     */
    @ModelAttribute
    public UserRole getUserRole(@PathVariable("userRole") Long id) {
        UserRole userRole = userRoleService.findOne(id);
        if (userRole == null) {
            throw new NotFoundException(String.format("UserRole with identifier '%s' not found", id));
        }
        return userRole;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute UserRole userRole, Model model) {
        return new ModelAndView("userroles/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @return UriComponents
     */
    public static UriComponents showURI(UserRole userRole) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(UserRolesItemThymeleafController.class).show(userRole, null)).buildAndExpand(userRole.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("userRole")
    public void initUserRoleBinder(WebDataBinder dataBinder) {
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
     * @param userRole
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute UserRole userRole, Model model) {
        populateForm(model);
        return new ModelAndView("userroles/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute UserRole userRole, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("userroles/edit");
        }
        UserRole savedUserRole = userRoleService.save(userRole);
        UriComponents showURI = UserRolesItemThymeleafController.showURI(savedUserRole);
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute UserRole userRole) {
        userRoleService.delete(userRole);
        return ResponseEntity.ok().build();
    }
}
