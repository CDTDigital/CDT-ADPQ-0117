package com.stanfieldsystems.repository;
import com.stanfieldsystems.Product;
import org.springframework.stereotype.Repository;

import com.stanfieldsystems.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ProductRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @return Long
     */
    public abstract long countByCategory(Category category);
}
