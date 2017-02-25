package com.stanfieldsystems.web;
import com.stanfieldsystems.Product;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = ProductsItemOrderProductsThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Product.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "orderProducts")
@RooThymeleaf
public class ProductsItemOrderProductsThymeleafController {
}
