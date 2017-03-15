package com.chaos.stanfield.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.chaos.stanfield.utils.JPAInitEMF;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * = Status
 *
 * TODO Auto-generated class documentation
 *
 */

@Entity
@SequenceGenerator(name="StatusSeq",initialValue=500)
public class Status {
	@Column(name="NAME")
    private String name;

	@Column(name="DESCRIPTION")
    private String description;

	
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "status")
    private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="StatusSeq")
    @Column(name = "id")
    private Long id;
   
    @Version
    @Column(name = "version")
    private Integer version;

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
    
    @JsonIgnore
    public Set<CustomerOrder> getCustomerOrders() {
        return this.customerOrders;
    }

    public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public String toString() {
        return "Status {" + "name='" + name + '\'' + ", description='" + description + '\'' + ", id='" + id ;
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

    public void addToCustomerOrders(Iterable<CustomerOrder> customerOrdersToAdd) {
        for (CustomerOrder item : customerOrdersToAdd) {
            this.customerOrders.add(item);
            item.setStatus(this);
        }
    }

    public void removeFromCustomerOrders(Iterable<CustomerOrder> customerOrdersToRemove) {
        for (CustomerOrder item : customerOrdersToRemove) {
            this.customerOrders.remove(item);
            item.setStatus(null);
        }
    }
    
    public ArrayList<Status> allStatus(){
		JPAInitEMF jpa=new JPAInitEMF();
		List<Object> listStatus=jpa.queryEntities("SELECT s from Status s");
		ArrayList<Status> statusList=new ArrayList<Status>();
		 for (Object object : listStatus) {
			 	statusList.add((Status)object);
	    }
		return statusList; 
	}
    
    
    public Status statusById(Long id){
		JPAInitEMF jpa=new JPAInitEMF();
		Status status=new Status();
		status.setId(id);
		status=jpa.getEm().find(Status.class,status.getId() );
		return status;
	}
    
    public Status statusByName(String name) {
		try {
			JPAInitEMF jpa = new JPAInitEMF();
			List<Status> listStatus = jpa.getEm().createQuery("SELECT s from Status s where s.name LIKE :n").setParameter("n", name).getResultList();
			System.out.println(listStatus.size());
			if (listStatus == null) {
				return null;
			}
			return listStatus.get(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No Data Found");
		}
		return null;
	}
    
}
