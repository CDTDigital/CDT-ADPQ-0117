package com.stanfieldsystems.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import com.stanfieldsystems.Category;
import org.springframework.stereotype.Repository;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import com.stanfieldsystems.QCategory;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CategoryRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public class CategoryRepositoryImpl extends QueryDslRepositorySupportExt<Category> implements CategoryRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    CategoryRepositoryImpl() {
        super(Category.class);
    }

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String DESCRIPTION = "description";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String NAME = "name";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Category> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCategory category = QCategory.category;
        JPQLQuery<Category> query = from(category);
        Path<?>[] paths = new Path<?>[] { category.name, category.description };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, category.name).map(DESCRIPTION, category.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, category);
    }
}
