package com.stanfieldsystems.web;
import com.stanfieldsystems.UserRole;
import com.stanfieldsystems.service.api.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = UserRoleDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooDeserializer(entity = UserRole.class)
@JsonComponent
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

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return UserRole
     */
    public UserRole deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        UserRole userRole = userRoleService.findOne(id);
        if (userRole == null) {
            throw new NotFoundException("UserRole not found");
        }
        return userRole;
    }
}
