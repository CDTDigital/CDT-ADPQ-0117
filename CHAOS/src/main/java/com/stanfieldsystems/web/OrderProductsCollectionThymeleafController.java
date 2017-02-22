package com.stanfieldsystems.web;
import com.stanfieldsystems.OrderProduct;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = OrderProductsCollectionThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = OrderProduct.class, type = ControllerType.COLLECTION)
@RooThymeleaf
public class OrderProductsCollectionThymeleafController {
}
