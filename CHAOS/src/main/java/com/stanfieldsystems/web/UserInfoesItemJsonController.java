package com.stanfieldsystems.web;
import com.stanfieldsystems.UserInfo;

import com.stanfieldsystems.service.api.UserInfoService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = UserInfoesItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooController(entity = UserInfo.class, pathPrefix = "/api", type = ControllerType.ITEM)
//@RooJSON
@RestController
@RequestMapping(value = "/api/userinfoes/{userInfo}", name = "UserInfoesItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserInfoesItemJsonController {

    /**
     * TODO Auto-generated field documentation
     *
     */
    public UserInfoService userInfoService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param userInfoService
     */
    @Autowired
    public UserInfoesItemJsonController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return UserInfo
     */
    @ModelAttribute
    public UserInfo getUserInfo(@PathVariable("userInfo") Long id) {
        UserInfo userInfo = userInfoService.findOne(id);
        if (userInfo == null) {
            throw new NotFoundException(String.format("UserInfo with identifier '%s' not found", id));
        }
        return userInfo;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute UserInfo userInfo) {
        return ResponseEntity.status(HttpStatus.FOUND).body(userInfo);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @return UriComponents
     */
    public static UriComponents showURI(UserInfo userInfo) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(UserInfoesItemJsonController.class).show(userInfo)).buildAndExpand(userInfo.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedUserInfo
     * @param userInfo
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute UserInfo storedUserInfo, @Valid @RequestBody UserInfo userInfo, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        userInfo.setId(storedUserInfo.getId());
        userInfoService.save(userInfo);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute UserInfo userInfo) {
        userInfoService.delete(userInfo);
        return ResponseEntity.ok().build();
    }
}
