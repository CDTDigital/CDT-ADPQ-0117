package com.stanfieldsystems.web;
import com.stanfieldsystems.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stanfieldsystems.Category;
import com.stanfieldsystems.OrderProduct;
import java.util.Set;

/**
 * = ProductJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooJsonMixin(entity = Product.class)
public abstract class ProductJsonMixin {

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
    @JsonDeserialize(using = CategoryDeserializer.class)
    private Category category;
}
