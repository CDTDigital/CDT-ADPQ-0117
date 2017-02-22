package com.stanfieldsystems.web;
import com.stanfieldsystems.UserInfo;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = UserInfoesCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = UserInfo.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
public class UserInfoesCollectionJsonController {
}
