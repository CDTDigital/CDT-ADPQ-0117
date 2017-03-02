package com.stanfieldsystems.web;
import com.stanfieldsystems.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stanfieldsystems.Product;
import java.util.Set;

/**
 * = CategoryJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
//@RooJsonMixin(entity = Category.class)
public abstract class CategoryJsonMixin {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @JsonIgnore
    private Set<Product> products;
}
