package com.stanfieldsystems.service.impl;
import com.stanfieldsystems.service.api.CategoryService;
import com.stanfieldsystems.Category;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.repository.CategoryRepository;
import com.stanfieldsystems.service.api.ProductService;
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

/**
 * = CategoryServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    /**
     * TODO Auto-generated field documentation
     *
     */
    private CategoryRepository categoryRepository;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private ProductService productService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param categoryRepository
     * @param productService
     */
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, @Lazy ProductService productService) {
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
    public Category addToProducts(Category category, Iterable<Long> productsToAdd) {
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
    public Category removeFromProducts(Category category, Iterable<Long> productsToRemove) {
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
    public Category setProducts(Category category, Iterable<Long> products) {
        List<Product> items = productService.findAll(products);
        Set<Product> currents = category.getProducts();
        Set<Product> toRemove = new HashSet<Product>();
        for (Iterator<Product> iterator = currents.iterator(); iterator.hasNext(); ) {
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
    public void delete(Category category) {
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
    public List<Category> save(Iterable<Category> entities) {
        return categoryRepository.save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
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
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Category
     */
    public Category findOne(Long id) {
        return categoryRepository.findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Category> findAll(Iterable<Long> ids) {
        return categoryRepository.findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return categoryRepository.count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Category> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return categoryRepository.findAll(globalSearch, pageable);
    }
}
