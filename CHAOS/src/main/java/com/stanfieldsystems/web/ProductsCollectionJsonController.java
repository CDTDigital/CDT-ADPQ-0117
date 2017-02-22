package com.stanfieldsystems.web;
import com.stanfieldsystems.Product;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = ProductsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Product.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
public class ProductsCollectionJsonController {
}
