package com.stanfieldsystems.web;
import com.stanfieldsystems.UserRole;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = UserRolesItemUserInfosThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = UserRole.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "userInfos")
@RooThymeleaf
public class UserRolesItemUserInfosThymeleafController {
}
