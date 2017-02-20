package com.dbtest.web;
import com.dbtest.HelloDb;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = HelloDbsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = HelloDb.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
public class HelloDbsCollectionJsonController {
}
