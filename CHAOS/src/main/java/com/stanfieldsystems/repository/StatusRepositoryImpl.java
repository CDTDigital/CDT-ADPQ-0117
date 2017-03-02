package com.stanfieldsystems.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.stereotype.Repository;

import com.stanfieldsystems.Status;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import com.stanfieldsystems.QStatus;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = StatusRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public class StatusRepositoryImpl extends QueryDslRepositorySupportExt<Status> implements StatusRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    StatusRepositoryImpl() {
        super(Status.class);
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
    public Page<Status> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QStatus status = QStatus.status;
        JPQLQuery<Status> query = from(status);
        Path<?>[] paths = new Path<?>[] { status.name, status.description };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, status.name).map(DESCRIPTION, status.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, status);
    }
}
