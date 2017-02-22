package com.stanfieldsystems.web;
import com.stanfieldsystems.UserInfo;
import com.stanfieldsystems.service.api.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = UserInfoDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = UserInfo.class)
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
}
