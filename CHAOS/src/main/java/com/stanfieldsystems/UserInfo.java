package com.stanfieldsystems;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;

/**
 * = UserInfo
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
public class UserInfo {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private UserRole userRole;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String username;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String displayName;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String password;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String email;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String phone;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String address;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "userInfo")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>();
}
