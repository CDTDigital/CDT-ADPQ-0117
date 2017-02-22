package com.stanfieldsystems.web;
import com.stanfieldsystems.Status;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = StatusesCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Status.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
public class StatusesCollectionJsonController {
}
