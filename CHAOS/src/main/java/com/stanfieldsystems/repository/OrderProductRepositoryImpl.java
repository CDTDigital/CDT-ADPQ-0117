package com.stanfieldsystems.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.stanfieldsystems.OrderProduct;

/**
 * = OrderProductRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@RooJpaRepositoryCustomImpl(repository = OrderProductRepositoryCustom.class)
public class OrderProductRepositoryImpl extends QueryDslRepositorySupportExt<OrderProduct> {

    /**
     * TODO Auto-generated constructor documentation
     */
    OrderProductRepositoryImpl() {
        super(OrderProduct.class);
    }
}