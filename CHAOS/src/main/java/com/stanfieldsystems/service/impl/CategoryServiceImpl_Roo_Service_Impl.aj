// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stanfieldsystems.service.impl;

import com.stanfieldsystems.Category;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.repository.CategoryRepository;
import com.stanfieldsystems.service.api.CategoryService;
import com.stanfieldsystems.service.api.ProductService;
import com.stanfieldsystems.service.impl.CategoryServiceImpl;
import io.springlets.data.domain.GlobalSearch;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CategoryServiceImpl_Roo_Service_Impl {
    
    declare parents: CategoryServiceImpl implements CategoryService;
    
    declare @type: CategoryServiceImpl: @Service;
    
    declare @type: CategoryServiceImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated attribute documentation
     */
    private CategoryRepository CategoryServiceImpl.categoryRepository;
    
    /**
     * TODO Auto-generated attribute documentation
     */
    private ProductService CategoryServiceImpl.productService;
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param categoryRepository
     * @param productService
     */
    @Autowired
    public CategoryServiceImpl.new(CategoryRepository categoryRepository, @Lazy ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @param category
     * @param productsToAdd
     * @return Category
     */
    @Transactional
    public Category CategoryServiceImpl.addToProducts(Category category, Iterable<Long> productsToAdd) {
        List<Product> products = productService.findAll(productsToAdd);
        category.addToProducts(products);
        return categoryRepository.save(category);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param category
     * @param productsToRemove
     * @return Category
     */
    @Transactional
    public Category CategoryServiceImpl.removeFromProducts(Category category, Iterable<Long> productsToRemove) {
        List<Product> products = productService.findAll(productsToRemove);
        category.removeFromProducts(products);
        return categoryRepository.save(category);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param category
     * @param products
     * @return Category
     */
    @Transactional
    public Category CategoryServiceImpl.setProducts(Category category, Iterable<Long> products) {
        List<Product> items = productService.findAll(products);
        Set<Product> currents = category.getProducts();
        Set<Product> toRemove = new HashSet<Product>();
        for (Iterator<Product> iterator = currents.iterator(); iterator.hasNext();) {
            Product nextProduct = iterator.next();
            if (items.contains(nextProduct)) {
                items.remove(nextProduct);
            } else {
                toRemove.add(nextProduct);
            }
        }
        category.removeFromProducts(toRemove);
        category.addToProducts(items);
        return categoryRepository.save(category);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param category
     */
    @Transactional
    public void CategoryServiceImpl.delete(Category category) {
        // Clear bidirectional one-to-many parent relationship with Product
        for (Product item : category.getProducts()) {
            item.setCategory(null);
        }
        
        categoryRepository.delete(category);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    @Transactional
    public List<Category> CategoryServiceImpl.save(Iterable<Category> entities) {
        return categoryRepository.save(entities);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    @Transactional
    public void CategoryServiceImpl.delete(Iterable<Long> ids) {
        List<Category> toDelete = categoryRepository.findAll(ids);
        categoryRepository.deleteInBatch(toDelete);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Category
     */
    @Transactional
    public Category CategoryServiceImpl.save(Category entity) {
        return categoryRepository.save(entity);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Category
     */
    public Category CategoryServiceImpl.findOne(Long id) {
        return categoryRepository.findOne(id);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public List<Category> CategoryServiceImpl.findAll(Iterable<Long> ids) {
        return categoryRepository.findAll(ids);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public List<Category> CategoryServiceImpl.findAll() {
        return categoryRepository.findAll();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public long CategoryServiceImpl.count() {
        return categoryRepository.count();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Category> CategoryServiceImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        return categoryRepository.findAll(globalSearch, pageable);
    }
    
}
