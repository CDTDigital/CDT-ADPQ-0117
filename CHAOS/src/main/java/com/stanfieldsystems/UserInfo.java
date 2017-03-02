package com.stanfieldsystems;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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
 * = UserInfo
 *
 * TODO Auto-generated class documentation
 *
 */

@Entity
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
    private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>();

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
     * @return UserRole
     */
    public UserRole getUserRole() {
        return this.userRole;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     */
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<CustomerOrder> getCustomerOrders() {
        return this.customerOrders;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrders
     */
    public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "UserInfo {" + "username='" + username + '\'' + ", displayName='" + displayName + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' + ", id='" + id + '\'' + ", version='" + version + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
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
     * @param customerOrdersToAdd
     */
    public void addToCustomerOrders(Iterable<CustomerOrder> customerOrdersToAdd) {
        for (CustomerOrder item : customerOrdersToAdd) {
            this.customerOrders.add(item);
            item.setUserInfo(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrdersToRemove
     */
    public void removeFromCustomerOrders(Iterable<CustomerOrder> customerOrdersToRemove) {
        for (CustomerOrder item : customerOrdersToRemove) {
            this.customerOrders.remove(item);
            item.setUserInfo(null);
        }
    }
}
