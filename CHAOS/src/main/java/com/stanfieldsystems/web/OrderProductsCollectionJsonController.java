package com.stanfieldsystems.web;
import com.stanfieldsystems.OrderProduct;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = OrderProductsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = OrderProduct.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
public class OrderProductsCollectionJsonController {
}
