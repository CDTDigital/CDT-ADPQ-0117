package com.stanfieldsystems.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.stereotype.Repository;

import com.stanfieldsystems.UserRole;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import com.stanfieldsystems.QUserRole;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = UserRoleRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public class UserRoleRepositoryImpl extends QueryDslRepositorySupportExt<UserRole> implements UserRoleRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    UserRoleRepositoryImpl() {
        super(UserRole.class);
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
    public Page<UserRole> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QUserRole userRole = QUserRole.userRole;
        JPQLQuery<UserRole> query = from(userRole);
        Path<?>[] paths = new Path<?>[] { userRole.name, userRole.description };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, userRole.name).map(DESCRIPTION, userRole.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, userRole);
    }
}
