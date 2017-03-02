package com.stanfieldsystems;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * = CustomerOrder
 *
 * TODO Auto-generated class documentation
 *
 */

@Entity
public class CustomerOrder {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "customerOrder")
    private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

    /**
     * TODO Auto-generated field documentation
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar orderDate;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private BigDecimal totalPrice;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * TODO Auto-generated field documentation
     *
     */
    @Version
    @Column(name = "version")
    private Integer version;

    /**
     * TODO Auto-generated method documentation
     *
     * @return UserInfo
     */
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Status
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<OrderProduct> getOrderProducts() {
        return this.orderProducts;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProducts
     */
    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getOrderDate() {
        return this.orderDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDate
     */
    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param totalPrice
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "CustomerOrder {" + "orderDate='" + orderDate + '\'' + ", totalPrice='" + totalPrice + '\'' + ", id='" + id + '\'' + ", version='" + version + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getVersion() {
        return this.version;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProductsToAdd
     */
    public void addToOrderProducts(Iterable<OrderProduct> orderProductsToAdd) {
        for (OrderProduct item : orderProductsToAdd) {
            this.orderProducts.add(item);
            item.setCustomerOrder(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProductsToRemove
     */
    public void removeFromOrderProducts(Iterable<OrderProduct> orderProductsToRemove) {
        for (OrderProduct item : orderProductsToRemove) {
            this.orderProducts.remove(item);
            item.setCustomerOrder(null);
        }
    }
}
