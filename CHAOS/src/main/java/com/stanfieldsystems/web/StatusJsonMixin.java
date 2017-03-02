package com.stanfieldsystems.web;
import com.stanfieldsystems.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stanfieldsystems.CustomerOrder;
import java.util.Set;

/**
 * = StatusJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooJsonMixin(entity = Status.class)
public abstract class StatusJsonMixin {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @JsonIgnore
    private Set<CustomerOrder> customerOrders;
}
