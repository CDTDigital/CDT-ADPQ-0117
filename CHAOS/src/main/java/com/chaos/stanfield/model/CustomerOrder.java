package com.chaos.stanfield.model;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import com.chaos.stanfield.utils.JPAInitEMF;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
@Table
@SequenceGenerator(name="CustomerOrderSeq", initialValue=500)
public class CustomerOrder {

    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;

    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "customerOrder")
    private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

    @Column(name="ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar orderDate;

    @Column(name="TOTAL_PRICE")
    private BigDecimal totalPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="CustomerOrderSeq")
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    @JsonIgnore
    public Set<OrderProduct> getOrderProducts() {
        return this.orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Calendar getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

  

    @Override
	public String toString() {
		return "CustomerOrder [userInfo=" + userInfo + ", status=" + status + ", orderProducts=" + orderProducts
				+ ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", id=" + id + ", version=" + version
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
            item.setCustomerOrder(this);
        }
    }

    public void removeFromOrderProducts(Iterable<OrderProduct> orderProductsToRemove) {
        for (OrderProduct item : orderProductsToRemove) {
            this.orderProducts.remove(item);
            item.setCustomerOrder(null);
        }
    }
    
    
    public ArrayList<CustomerOrder> allCustomerOrders(){
		JPAInitEMF jpa=new JPAInitEMF();
		List<Object> listCustomerOrders=jpa.queryEntities("SELECT c from CustomerOrder c");
		ArrayList<CustomerOrder> customerOrderList=new ArrayList<CustomerOrder>();
		 for (Object object : listCustomerOrders) {
			 	customerOrderList.add((CustomerOrder)object);
	    }
		return customerOrderList; 
	}
    
    public List<CustomerOrder> customerOrderByUsername(String username) {
		try {
			JPAInitEMF jpa = new JPAInitEMF();
			List<CustomerOrder> listcustomerOrder = jpa.getEm().createQuery("SELECT c from CustomerOrder c where c.userInfo.username LIKE :un").setParameter("un", username).getResultList();
			System.out.println(listcustomerOrder.size());
			if (listcustomerOrder == null) {
				return null;
			}
			return listcustomerOrder;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No Data Found");
		}
		return null;
	}
    
    public CustomerOrder customerOrderById(Long id){
  		JPAInitEMF jpa=new JPAInitEMF();
  		CustomerOrder customerOrder=new CustomerOrder();
  		customerOrder.setId(id);
  		customerOrder=jpa.getEm().find(CustomerOrder.class,customerOrder.getId() );
  		return customerOrder;
  	}
    
    
}
