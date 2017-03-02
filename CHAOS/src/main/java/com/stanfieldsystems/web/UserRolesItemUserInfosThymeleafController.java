package com.stanfieldsystems.web;
import com.stanfieldsystems.UserRole;
import com.stanfieldsystems.UserInfo;
import com.stanfieldsystems.service.api.UserInfoService;
import com.stanfieldsystems.service.api.UserRoleService;
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
 * = UserRolesItemUserInfosThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = UserRole.class, type = ControllerType.DETAIL)
//@RooDetail(relationField = "userInfos")
//@RooThymeleaf
@Controller
@RequestMapping(value = "/userroles/{userRole}/userInfos", name = "UserRolesItemUserInfosThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class UserRolesItemUserInfosThymeleafController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public UserInfoService userInfoService;

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
     * @param userInfoService
     * @param messageSource
     */
    @Autowired
    public UserRolesItemUserInfosThymeleafController(UserRoleService userRoleService, UserInfoService userInfoService, MessageSource messageSource) {
        this.userRoleService = userRoleService;
        this.userInfoService = userInfoService;
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
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<DatatablesData<UserInfo>> datatables(@ModelAttribute UserRole userRole, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<UserInfo> userInfos = userInfoService.findByUserRole(userRole, search, pageable);
        long totalUserInfosCount = userInfoService.countByUserRole(userRole);
        DatatablesData<UserInfo> data = new DatatablesData<UserInfo>(userInfos, totalUserInfosCount, draw);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param UserRole
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute UserRole UserRole, Model model) {
        populateForm(model);
        model.addAttribute(new UserInfo());
        return new ModelAndView("userroles/userInfos/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param userInfosToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromUserInfos", value = "/{userInfosToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromUserInfos(@ModelAttribute UserRole userRole, @PathVariable("userInfosToRemove") Long userInfosToRemove) {
        userRoleService.removeFromUserInfos(userRole, Collections.singleton(userInfosToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param userInfos
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute UserRole userRole, @RequestParam("userInfosIds") List<Long> userInfos, Model model) {
        // Remove empty values
        for (Iterator<Long> iterator = userInfos.iterator(); iterator.hasNext(); ) {
            if (iterator.next() == null) {
                iterator.remove();
            }
        }
        userRoleService.setUserInfos(userRole, userInfos);
        UriComponents listURI = UserRolesCollectionThymeleafController.listURI();
        return new ModelAndView("redirect:" + listURI.toUriString());
    }
}
