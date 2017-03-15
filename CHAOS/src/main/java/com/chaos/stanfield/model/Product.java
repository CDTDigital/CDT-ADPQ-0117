package com.chaos.stanfield.model;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.chaos.stanfield.utils.JPAInitEMF;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
@SequenceGenerator(name="ProductSeq" ,initialValue=500)
public class Product {

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(name="NAME",length=1500)
    private String name;

    @Column(name="DESCRIPTION",length=1500)
    private String description;

    @Column(name="QUANTITY")
    private BigDecimal quantity;

    @Column(name="MSRP")
    private BigDecimal MSRP;

    @Column(name="PRICE")
    private BigDecimal price;

    @Column(name="DISCOUNT")
    private BigDecimal discount;

    @Column(name="CLIN")
    private String CLIN;

    @Column(name="OEM")
    private String OEM;

    @Column(name="OEM_NAME")
    private String OEM_NAME;

    @Column(name="SKU")
    private String SKU;

    public String getOEM_NAME() {
		return OEM_NAME;
	}

	public void setOEM_NAME(String oEM_NAME) {
		OEM_NAME = oEM_NAME;
	}

	@Column(name="UNIT_MEASURE")
    private String unitMeasure;

    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

    @Column(name="UNSPSC")
    private String UNSPSC;

    @Version
    @Column(name = "version")
    private Integer version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ProductSeq")
    @Column(name = "id")
    private Long id;

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getMSRP() {
        return this.MSRP;
    }

    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }

    public BigDecimal getPrice() {
        return this.price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getCLIN() {
        return this.CLIN;
    }

    public void setCLIN(String CLIN) {
        this.CLIN = CLIN;
    }

    public String getOEM() {
        return this.OEM;
    }

    public void setOEM(String OEM) {
        this.OEM = OEM;
    }

    public String getSKU() {
        return this.SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getUnitMeasure() {
        return this.unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }
    
    @JsonIgnore
    public Set<OrderProduct> getOrderProducts() {
        return this.orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getUNSPSC() {
        return this.UNSPSC;
    }

    public void setUNSPSC(String UNSPSC) {
        this.UNSPSC = UNSPSC;
    }

    @Override
	public String toString() {
		return "Product [category=" + category + ", name=" + name + ", description=" + description + ", quantity="
				+ quantity + ", MSRP=" + MSRP + ", price=" + price + ", discount=" + discount + ", CLIN=" + CLIN
				+ ", OEM=" + OEM + ", OEM_NAME=" + OEM_NAME + ", SKU=" + SKU + ", unitMeasure=" + unitMeasure
				+ ", orderProducts=" + orderProducts + ", UNSPSC=" + UNSPSC + ", version=" + version + ", id=" + id
				+ "]";
	}

	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void addToOrderProducts(Iterable<OrderProduct> orderProductsToAdd) {
        for (OrderProduct item : orderProductsToAdd) {
            this.orderProducts.add(item);
            item.setProduct(this);
        }
    }

    public void removeFromOrderProducts(Iterable<OrderProduct> orderProductsToRemove) {
        for (OrderProduct item : orderProductsToRemove) {
            this.orderProducts.remove(item);
            item.setProduct(null);
        }
    }
    
    
    
    public ArrayList<Product> allProducts(){
		JPAInitEMF jpa=new JPAInitEMF();
		List<Object> listProduct=jpa.queryEntities("SELECT p from Product p");
		ArrayList<Product> productList=new ArrayList<Product>();
		 for (Object object : listProduct) {
			 	productList.add((Product)object);
	    }
		return productList; 
	}
    
    
    public List<Product> productsByCategory(String name) {
		try {
			JPAInitEMF jpa = new JPAInitEMF();
			List<Product> listProduct = jpa.getEm().createQuery("SELECT p from Product p where p.category.name LIKE :cat").setParameter("cat", name).getResultList();
			System.out.println(listProduct.size());
			if (listProduct == null) {
				return null;
			}
			return listProduct;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No Data Found");
		}
		return null;
	}
    
    public Product productById(Long id){
		JPAInitEMF jpa=new JPAInitEMF();
		Product product=new Product();
		product.setId(id);
		product=jpa.getEm().find(Product.class,product.getId() );
		return product;
	}
    
}
