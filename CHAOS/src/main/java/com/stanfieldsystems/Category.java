package com.stanfieldsystems;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * = Category
 *
 * TODO Auto-generated class documentation
 *
 */

@Entity
public class Category {

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
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "category")
    
    private Set<Product> products = new HashSet<Product>();

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
     * @return Set
     */
    public Set<Product> getProducts() {
        return this.products;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param products
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Category {" + "name='" + name + '\'' + ", description='" + description + '\'' + ", id='" + id + '\'' + ", version='" + version + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
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
     * @param productsToAdd
     */
    public void addToProducts(Iterable<Product> productsToAdd) {
        for (Product item : productsToAdd) {
            this.products.add(item);
            item.setCategory(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productsToRemove
     */
    public void removeFromProducts(Iterable<Product> productsToRemove) {
        for (Product item : productsToRemove) {
            this.products.remove(item);
            item.setCategory(null);
        }
    }
}
