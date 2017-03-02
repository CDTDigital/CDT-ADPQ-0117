package com.stanfieldsystems.service.api;
import com.stanfieldsystems.Product;
import org.springframework.stereotype.Service;

import com.stanfieldsystems.Category;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = ProductService
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
public interface ProductService {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Product
     */
    public abstract Product findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     */
    public abstract void delete(Product product);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Product> save(Iterable<Product> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Product
     */
    public abstract Product save(Product entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Product> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Product> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderProductsToAdd
     * @return Product
     */
    public abstract Product addToOrderProducts(Product product, Iterable<Long> orderProductsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderProductsToRemove
     * @return Product
     */
    public abstract Product removeFromOrderProducts(Product product, Iterable<Long> orderProductsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderProducts
     * @return Product
     */
    public abstract Product setOrderProducts(Product product, Iterable<Long> orderProducts);

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findByCategory(Category category, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @return Long
     */
    public abstract long countByCategory(Category category);
}
