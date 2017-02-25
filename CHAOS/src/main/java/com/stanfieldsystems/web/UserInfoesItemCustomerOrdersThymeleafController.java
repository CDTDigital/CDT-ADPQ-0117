package com.stanfieldsystems.web;
import com.stanfieldsystems.UserInfo;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = UserInfoesItemCustomerOrdersThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = UserInfo.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "customerOrders")
@RooThymeleaf
public class UserInfoesItemCustomerOrdersThymeleafController {
}
