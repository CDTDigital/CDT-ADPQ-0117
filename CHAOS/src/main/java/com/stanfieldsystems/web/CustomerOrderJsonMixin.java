package com.stanfieldsystems.web;
import com.stanfieldsystems.CustomerOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.Status;
import com.stanfieldsystems.UserInfo;
import java.util.Set;

/**
 * = CustomerOrderJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooJsonMixin(entity = CustomerOrder.class)
public abstract class CustomerOrderJsonMixin {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @JsonDeserialize(using = UserInfoDeserializer.class)
    private UserInfo userInfo;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @JsonIgnore
    private Set<OrderProduct> orderProducts;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @JsonDeserialize(using = StatusDeserializer.class)
    private Status status;
}
