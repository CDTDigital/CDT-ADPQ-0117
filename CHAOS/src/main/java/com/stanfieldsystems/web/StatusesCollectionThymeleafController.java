package com.stanfieldsystems.web;
import com.stanfieldsystems.Status;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = StatusesCollectionThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Status.class, type = ControllerType.COLLECTION)
@RooThymeleaf
public class StatusesCollectionThymeleafController {
}
