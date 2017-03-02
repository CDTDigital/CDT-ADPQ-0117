package com.stanfieldsystems.repository;
import com.stanfieldsystems.Category;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CategoryRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom {
}
