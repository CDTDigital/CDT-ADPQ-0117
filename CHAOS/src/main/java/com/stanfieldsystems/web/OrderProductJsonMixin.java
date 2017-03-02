package com.stanfieldsystems.web;
import com.stanfieldsystems.OrderProduct;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.Product;

/**
 * = OrderProductJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooJsonMixin(entity = OrderProduct.class)
public abstract class OrderProductJsonMixin {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @JsonDeserialize(using = ProductDeserializer.class)
    private Product product;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @JsonDeserialize(using = CustomerOrderDeserializer.class)
    private CustomerOrder customerOrder;
}
