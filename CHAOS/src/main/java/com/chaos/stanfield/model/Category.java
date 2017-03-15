package com.chaos.stanfield.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.FetchType;
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
@SequenceGenerator(name="CategorySeq", initialValue=500)
public class Category {

	@Column(name="NAME")
    private String name;


	@Column(name="DESCRIPTION")
    private String description;

    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Product> products = new HashSet<Product>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="CategorySeq")
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
    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

   
    @Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + ", products=" + products + ", id=" + id
				+ ", version=" + version + "]";
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

    public void addToProducts(Iterable<Product> productsToAdd) {
        for (Product item : productsToAdd) {
            this.products.add(item);
            item.setCategory(this);
        }
    }

    public void removeFromProducts(Iterable<Product> productsToRemove) {
        for (Product item : productsToRemove) {
            this.products.remove(item);
            item.setCategory(null);
        }
    }
    
	public ArrayList<Category> allCategories(){
		JPAInitEMF jpa=new JPAInitEMF();
		List<Object> listCategory=jpa.queryEntities("SELECT c from Category c");
		ArrayList<Category> categoryList=new ArrayList<Category>();
		 for (Object object : listCategory) {
			 	categoryList.add((Category)object);
	    }
		return categoryList; 
	}
    
	
	public Category categoryById(Long id){
		JPAInitEMF jpa=new JPAInitEMF();
		Category category=new Category();
		category.setId(id);
		category=jpa.getEm().find(Category.class,category.getId() );
		return category;
	}
    
    
}
