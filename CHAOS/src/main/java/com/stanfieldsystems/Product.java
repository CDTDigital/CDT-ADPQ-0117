package com.stanfieldsystems;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;

/**
 * = Product
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
public class Product {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String name;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String description;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private BigDecimal quantity;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private BigDecimal MSRP;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private BigDecimal price;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private BigDecimal discount;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String CLIN;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String OEM;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String OEM_name;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String SKU;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String unitMeasure;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "product")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String UNSPSC;
}
