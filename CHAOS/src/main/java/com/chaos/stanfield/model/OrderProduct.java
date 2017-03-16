package com.chaos.stanfield.model;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.criteria.Order;

import com.chaos.stanfield.utils.JPAInitEMF;



@Entity
@Table
@SequenceGenerator(name="orderProductSeq",initialValue=500)
public class OrderProduct {

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(name="QUANTITY")
    private BigDecimal quantity;

    @Column(name="PRICE")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerOrder customerOrder;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="orderProductSeq")
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CustomerOrder getCustomerOrder() {
        return this.customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }



    @Override
	public String toString() {
		return "OrderProduct [product=" + product + ", quantity=" + quantity + ", price=" + price + ", customerOrder="
				+ customerOrder + ", id=" + id + ", version=" + version + "]";
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
    
    
    public ArrayList<OrderProduct> allOrderProducts(){
		JPAInitEMF jpa=new JPAInitEMF();
		List<Object> listOrderProduct=jpa.queryEntities("SELECT o from OrderProduct o");
		ArrayList<OrderProduct> orderProductList=new ArrayList<OrderProduct>();
		 for (Object object : listOrderProduct) {
			 	orderProductList.add((OrderProduct)object);
	    }
		return orderProductList; 
	}
    
    
    
    public List<OrderProduct> OrderProductByCustomerOrderId(Long id) {
		try {
			JPAInitEMF jpa = new JPAInitEMF();
			List<OrderProduct> listOrderProduct = jpa.getEm().createQuery("SELECT o from OrderProduct o where o.customerOrder.id = :un").setParameter("un", id).getResultList();
			System.out.println(listOrderProduct.size());
			if (listOrderProduct == null) {
				return null;
			}
			return listOrderProduct;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No Data Found");
		}
		return null;
	}
    
    public OrderProduct orderProductById(Long id){
  		JPAInitEMF jpa=new JPAInitEMF();
  		OrderProduct orderProduct=new OrderProduct();
  		orderProduct.setId(id);
  		orderProduct=jpa.getEm().find(OrderProduct.class,orderProduct.getId() );
  		return orderProduct;
  	}
     
    
    
    
    
}
