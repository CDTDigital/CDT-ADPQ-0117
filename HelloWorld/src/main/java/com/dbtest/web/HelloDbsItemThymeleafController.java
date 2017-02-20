package com.dbtest.web;
import com.dbtest.HelloDb;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = HelloDbsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = HelloDb.class, type = ControllerType.ITEM)
@RooThymeleaf
public class HelloDbsItemThymeleafController {
}
