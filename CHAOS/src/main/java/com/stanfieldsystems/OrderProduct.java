package com.stanfieldsystems;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * = OrderProduct
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
public class OrderProduct {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String name;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private BigDecimal quantity;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private BigDecimal price;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerOrder customerOrder;
}
