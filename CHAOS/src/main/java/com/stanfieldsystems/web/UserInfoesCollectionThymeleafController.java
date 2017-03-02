package com.stanfieldsystems.web;
import com.stanfieldsystems.UserInfo;

import com.stanfieldsystems.service.api.UserInfoService;
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

/**
 * = UserInfoesCollectionThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = UserInfo.class, type = ControllerType.COLLECTION)
//@RooThymeleaf
@Controller
@RequestMapping(value = "/userinfoes", name = "UserInfoesCollectionThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class UserInfoesCollectionThymeleafController {

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
    public UserInfoesCollectionThymeleafController(UserInfoService userInfoService, MessageSource messageSource) {
        this.userInfoService = userInfoService;
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
    public ModelAndView list(Model model) {
        return new ModelAndView("/userinfoes/list");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(UserInfoesCollectionThymeleafController.class).list(null)).build().encode();
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
    public ResponseEntity<DatatablesData<UserInfo>> datatables(GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<UserInfo> userInfoes = userInfoService.findAll(search, pageable);
        long totalUserInfoesCount = userInfoes.getTotalElements();
        if (search != null && StringUtils.hasText(search.getText())) {
            totalUserInfoesCount = userInfoService.count();
        }
        DatatablesData<UserInfo> datatablesData = new DatatablesData<UserInfo>(userInfoes, totalUserInfoesCount, draw);
        return ResponseEntity.ok(datatablesData);
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
    public ResponseEntity<Select2Data<UserInfo>> select2(GlobalSearch search, Pageable pageable, Locale locale) {
        Page<UserInfo> UserInfoes = userInfoService.findAll(search, pageable);
        String idExpression = "#{id}";
        String textExpression = messageSource.getMessage("expression_userInfo", null, "#{toString()}", locale);
        Select2Data<UserInfo> select2Data = new Select2Data<UserInfo>(UserInfoes, idExpression, textExpression);
        return ResponseEntity.ok(select2Data);
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
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@Valid @ModelAttribute UserInfo userInfo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("/userinfoes/create");
        }
        UserInfo newUserInfo = userInfoService.save(userInfo);
        UriComponents showURI = UserInfoesItemThymeleafController.showURI(newUserInfo);
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(Model model) {
        populateForm(model);
        model.addAttribute(new UserInfo());
        return new ModelAndView("userinfoes/create");
    }
}
