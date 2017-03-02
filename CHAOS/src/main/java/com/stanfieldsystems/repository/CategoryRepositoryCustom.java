package com.stanfieldsystems.repository;
import com.stanfieldsystems.Category;
import org.springframework.stereotype.Repository;
import io.springlets.data.domain.GlobalSearch;
import javax.persistence.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CategoryRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface CategoryRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Category> findAll(GlobalSearch globalSearch, Pageable pageable);
}
