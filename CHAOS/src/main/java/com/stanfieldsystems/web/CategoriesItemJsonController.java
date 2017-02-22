package com.stanfieldsystems.web;
import com.stanfieldsystems.Category;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = CategoriesItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Category.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
public class CategoriesItemJsonController {
}
