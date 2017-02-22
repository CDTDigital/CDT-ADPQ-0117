// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stanfieldsystems.service.api;

import com.stanfieldsystems.Category;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.service.api.ProductService;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

privileged aspect ProductService_Roo_Service {
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Product
     */
    public abstract Product ProductService.findOne(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param product
     */
    public abstract void ProductService.delete(Product product);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    public abstract List<Product> ProductService.save(Iterable<Product> entities);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    public abstract void ProductService.delete(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Product
     */
    public abstract Product ProductService.save(Product entity);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public abstract List<Product> ProductService.findAll(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public abstract List<Product> ProductService.findAll();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public abstract long ProductService.count();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> ProductService.findAll(GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param product
     * @param orderProductsToAdd
     * @return Product
     */
    public abstract Product ProductService.addToOrderProducts(Product product, Iterable<Long> orderProductsToAdd);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param product
     * @param orderProductsToRemove
     * @return Product
     */
    public abstract Product ProductService.removeFromOrderProducts(Product product, Iterable<Long> orderProductsToRemove);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param product
     * @param orderProducts
     * @return Product
     */
    public abstract Product ProductService.setOrderProducts(Product product, Iterable<Long> orderProducts);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param category
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> ProductService.findByCategory(Category category, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param category
     * @return Long
     */
    public abstract long ProductService.countByCategory(Category category);
    
}
