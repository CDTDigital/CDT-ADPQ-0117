package com.stanfieldsystems.web;
import com.stanfieldsystems.UserInfo;

import com.stanfieldsystems.service.api.UserInfoService;
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
 * = UserInfoesItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = UserInfo.class, type = ControllerType.ITEM)
//@RooThymeleaf
@Controller
@RequestMapping(value = "/userinfoes/{userInfo}", name = "UserInfoesItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class UserInfoesItemThymeleafController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public UserInfoService userInfoService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public MessageSource messageSource;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param userInfoService
     * @param messageSource
     */
    @Autowired
    public UserInfoesItemThymeleafController(UserInfoService userInfoService, MessageSource messageSource) {
        this.userInfoService = userInfoService;
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
     * @param userInfo
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute UserInfo userInfo, Model model) {
        return new ModelAndView("userinfoes/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @return UriComponents
     */
    public static UriComponents showURI(UserInfo userInfo) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(UserInfoesItemThymeleafController.class).show(userInfo, null)).buildAndExpand(userInfo.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("userInfo")
    public void initUserInfoBinder(WebDataBinder dataBinder) {
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
     * @param userInfo
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute UserInfo userInfo, Model model) {
        populateForm(model);
        return new ModelAndView("userinfoes/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute UserInfo userInfo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("userinfoes/edit");
        }
        UserInfo savedUserInfo = userInfoService.save(userInfo);
        UriComponents showURI = UserInfoesItemThymeleafController.showURI(savedUserInfo);
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute UserInfo userInfo) {
        userInfoService.delete(userInfo);
        return ResponseEntity.ok().build();
    }
}
