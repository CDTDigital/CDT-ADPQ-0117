package com.stanfieldsystems.web;
import com.stanfieldsystems.UserInfo;
import com.stanfieldsystems.service.api.UserInfoService;
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
 * = UserInfoDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooDeserializer(entity = UserInfo.class)
@JsonComponent
public class UserInfoDeserializer extends JsonObjectDeserializer<UserInfo> {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public UserInfoService userInfoService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    public ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param userInfoService
     * @param conversionService
     */
    @Autowired
    public UserInfoDeserializer(UserInfoService userInfoService, ConversionService conversionService) {
        this.userInfoService = userInfoService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return UserInfo
     */
    public UserInfo deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        UserInfo userInfo = userInfoService.findOne(id);
        if (userInfo == null) {
            throw new NotFoundException("UserInfo not found");
        }
        return userInfo;
    }
}
