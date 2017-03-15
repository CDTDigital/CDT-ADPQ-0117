package com.chaos.stanfield.model;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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


/**
 * = UserInfo
 *
 * TODO Auto-generated class documentation
 *
 */

@Entity
@Table
@SequenceGenerator(name="UserInfoSeq",initialValue=500)
public class UserInfo {

    @ManyToOne(fetch = FetchType.LAZY)
    private UserRole userRole;

    @Column(name="USERNAME")
    private String username;

    @Column(name = "DISPLAY_NAME")
    private String displayName;
    
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADDRESS")
    private String address;

    @Version
    @Column(name = "version")
    private Integer version;
    
    public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "userInfo")
    private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="UserInfoSeq")
    @Column(name = "id")
    private Long id;

    public UserRole getUserRole() {
        return this.userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @JsonIgnore
    public Set<CustomerOrder> getCustomerOrders() {
        return this.customerOrders;
    }

    public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

   

    @Override
	public String toString() {
		return "UserInfo [userRole=" + userRole + ", username=" + username + ", displayName=" + displayName
				+ ", password=" + password + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", version=" + version + ", customerOrders=" + customerOrders + ", id=" + id + "]";
	}

	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void addToCustomerOrders(Iterable<CustomerOrder> customerOrdersToAdd) {
        for (CustomerOrder item : customerOrdersToAdd) {
            this.customerOrders.add(item);
            item.setUserInfo(this);
        }
    }

    public void removeFromCustomerOrders(Iterable<CustomerOrder> customerOrdersToRemove) {
        for (CustomerOrder item : customerOrdersToRemove) {
            this.customerOrders.remove(item);
            item.setUserInfo(null);
        }
    }
    
    
    public ArrayList<UserInfo> allUserInfoes(){
		JPAInitEMF jpa=new JPAInitEMF();
		List<Object> listUserInfo=jpa.queryEntities("SELECT u from UserInfo u");
		ArrayList<UserInfo> userInfoList=new ArrayList<UserInfo>();
		 for (Object object : listUserInfo) {
			 	userInfoList.add((UserInfo)object);
	    }
		return userInfoList; 
	}
    
    
    
	public UserInfo userInfoByEmail(String email) {
		try {
			JPAInitEMF jpa = new JPAInitEMF();
			List<UserInfo> listUserInfo = jpa.getEm().createQuery("SELECT u from UserInfo u where u.email LIKE :e").setParameter("e", email).getResultList();
			UserInfo u = new UserInfo();
			if (listUserInfo == null) {
				return null;
			}
			return (UserInfo) listUserInfo.get(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No Data Found");
		}
		return null;
	}
    
	public UserInfo userInfoByUsername(String username) {
		try {
			JPAInitEMF jpa = new JPAInitEMF();
			List<UserInfo> listUserInfo = jpa.getEm().createQuery("SELECT u from UserInfo u where u.username LIKE :user").setParameter("user", username).getResultList();
			UserInfo u = new UserInfo();
			if (listUserInfo == null) {
				return null;
			}
			return (UserInfo) listUserInfo.get(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No Data Found");
		}
		return null;
	}
    
	public UserInfo userInfoById(Long id){
		JPAInitEMF jpa=new JPAInitEMF();
		UserInfo userInfo=new UserInfo();
		userInfo.setId(id);
		userInfo=jpa.getEm().find(UserInfo.class,userInfo.getId() );
		return userInfo;
	}
    
    
	
}
