package com.stanfieldsystems.service.api;
import com.stanfieldsystems.Category;
import org.springframework.stereotype.Service;

import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CategoryService
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
public interface CategoryService {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Category
     */
    public abstract Category findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     */
    public abstract void delete(Category category);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Category> save(Iterable<Category> entities);

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
     * @return Category
     */
    public abstract Category save(Category entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Category> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Category> findAll();

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
    public abstract Page<Category> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param productsToAdd
     * @return Category
     */
    public abstract Category addToProducts(Category category, Iterable<Long> productsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param productsToRemove
     * @return Category
     */
    public abstract Category removeFromProducts(Category category, Iterable<Long> productsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param products
     * @return Category
     */
    public abstract Category setProducts(Category category, Iterable<Long> products);
}
