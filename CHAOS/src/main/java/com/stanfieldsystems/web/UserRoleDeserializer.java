package com.stanfieldsystems.web;
import com.stanfieldsystems.UserRole;
import com.stanfieldsystems.service.api.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = UserRoleDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = UserRole.class)
public class UserRoleDeserializer extends JsonObjectDeserializer<UserRole> {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public UserRoleService userRoleService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param userRoleService
     * @param conversionService
     */
    @Autowired
    public UserRoleDeserializer(UserRoleService userRoleService, ConversionService conversionService) {
        this.userRoleService = userRoleService;
        this.conversionService = conversionService;
    }
}
