package com.stanfieldsystems.web;
import com.stanfieldsystems.UserRole;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = UserRolesItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = UserRole.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
public class UserRolesItemJsonController {
}
