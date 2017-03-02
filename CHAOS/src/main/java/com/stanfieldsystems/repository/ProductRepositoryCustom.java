package com.stanfieldsystems.repository;
import com.stanfieldsystems.Product;
import org.springframework.stereotype.Repository;
import com.stanfieldsystems.Category;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = ProductRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface ProductRepositoryCustom {

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
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findAll(GlobalSearch globalSearch, Pageable pageable);
}
