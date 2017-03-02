package com.stanfieldsystems;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * = Product
 *
 * TODO Auto-generated class documentation
 *
 */

@Entity
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
    private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

    /**
     * TODO Auto-generated field documentation
     *
     */
    private String UNSPSC;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @Version
    @Column(name = "version")
    private Integer version;

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
     * TODO Auto-generated method documentation
     *
     * @return Category
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getQuantity() {
        return this.quantity;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param quantity
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getMSRP() {
        return this.MSRP;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param MSRP
     */
    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getDiscount() {
        return this.discount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param discount
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCLIN() {
        return this.CLIN;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param CLIN
     */
    public void setCLIN(String CLIN) {
        this.CLIN = CLIN;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getOEM() {
        return this.OEM;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param OEM
     */
    public void setOEM(String OEM) {
        this.OEM = OEM;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getOEM_name() {
        return this.OEM_name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param OEM_name
     */
    public void setOEM_name(String OEM_name) {
        this.OEM_name = OEM_name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getSKU() {
        return this.SKU;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param SKU
     */
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getUnitMeasure() {
        return this.unitMeasure;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param unitMeasure
     */
    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
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
     * @return String
     */
    public String getUNSPSC() {
        return this.UNSPSC;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param UNSPSC
     */
    public void setUNSPSC(String UNSPSC) {
        this.UNSPSC = UNSPSC;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Product {" + "name='" + name + '\'' + ", description='" + description + '\'' + ", quantity='" + quantity + '\'' + ", MSRP='" + MSRP + '\'' + ", price='" + price + '\'' + ", discount='" + discount + '\'' + ", CLIN='" + CLIN + '\'' + ", OEM='" + OEM + '\'' + ", OEM_name='" + OEM_name + '\'' + ", SKU='" + SKU + '\'' + ", unitMeasure='" + unitMeasure + '\'' + ", UNSPSC='" + UNSPSC + '\'' + ", id='" + id + '\'' + ", version='" + version + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
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
            item.setProduct(this);
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
            item.setProduct(null);
        }
    }
}
