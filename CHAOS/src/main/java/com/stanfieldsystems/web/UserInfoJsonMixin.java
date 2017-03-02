package com.stanfieldsystems.web;
import com.stanfieldsystems.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.UserRole;
import java.util.Set;

/**
 * = UserInfoJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooJsonMixin(entity = UserInfo.class)
public abstract class UserInfoJsonMixin {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @JsonIgnore
    private Set<CustomerOrder> customerOrders;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @JsonDeserialize(using = UserRoleDeserializer.class)
    private UserRole userRole;
}
