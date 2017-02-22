// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stanfieldsystems.web;

import com.stanfieldsystems.Category;
import com.stanfieldsystems.service.api.CategoryService;
import com.stanfieldsystems.web.CategoriesCollectionJsonController;
import com.stanfieldsystems.web.CategoriesItemJsonController;
import io.springlets.data.domain.GlobalSearch;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

privileged aspect CategoriesCollectionJsonController_Roo_JSON {
    
    declare @type: CategoriesCollectionJsonController: @RestController;
    
    declare @type: CategoriesCollectionJsonController: @RequestMapping(value = "/api/categories", name = "CategoriesCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE);
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param categoryService
     */
    @Autowired
    public CategoriesCollectionJsonController.new(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<Category>> CategoriesCollectionJsonController.list(GlobalSearch globalSearch, Pageable pageable) {
        
        Page<Category> categories = categoryService.findAll(globalSearch, pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(categories);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return UriComponents
     */
    public static UriComponents CategoriesCollectionJsonController.listURI() {
        return MvcUriComponentsBuilder
            .fromMethodCall(
                MvcUriComponentsBuilder.on(CategoriesCollectionJsonController.class).list(null, null))
            .build().encode();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param category
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> CategoriesCollectionJsonController.create(@Valid @RequestBody Category category, BindingResult result) {
        
        if (category.getId() != null || category.getVersion() != null) {        
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        
        Category newCategory = categoryService.save(category);
        UriComponents showURI = CategoriesItemJsonController.showURI(newCategory);
        
        return ResponseEntity.created(showURI.toUri()).build();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param categories
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> CategoriesCollectionJsonController.createBatch(@Valid @RequestBody Collection<Category> categories, BindingResult result) {
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        
        categoryService.save(categories);
        
        return ResponseEntity.created(listURI().toUri()).build();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param categories
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> CategoriesCollectionJsonController.updateBatch(@Valid @RequestBody Collection<Category> categories, BindingResult result) {
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        
        categoryService.save(categories);
        
        return ResponseEntity.ok().build();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return ResponseEntity
     */
    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> CategoriesCollectionJsonController.deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        
        categoryService.delete(ids);
        
        return ResponseEntity.ok().build();
    }
    
}
