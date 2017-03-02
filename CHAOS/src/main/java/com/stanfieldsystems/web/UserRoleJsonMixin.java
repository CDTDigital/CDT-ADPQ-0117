package com.stanfieldsystems.web;
import com.stanfieldsystems.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stanfieldsystems.UserInfo;
import java.util.Set;

/**
 * = UserRoleJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooJsonMixin(entity = UserRole.class)
public abstract class UserRoleJsonMixin {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @JsonIgnore
    private Set<UserInfo> userInfos;
}
