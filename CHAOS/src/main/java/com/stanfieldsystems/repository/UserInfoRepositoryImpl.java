package com.stanfieldsystems.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.stereotype.Repository;

import com.stanfieldsystems.UserInfo;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import com.stanfieldsystems.QUserInfo;
import com.stanfieldsystems.UserRole;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = UserInfoRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public class UserInfoRepositoryImpl extends QueryDslRepositorySupportExt<UserInfo> implements UserInfoRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    UserInfoRepositoryImpl() {
        super(UserInfo.class);
    }

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String PASSWORD = "password";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String PHONE = "phone";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String ADDRESS = "address";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String USERNAME = "username";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String EMAIL = "email";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String DISPLAY_NAME = "displayName";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<UserInfo> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QUserInfo userInfo = QUserInfo.userInfo;
        JPQLQuery<UserInfo> query = from(userInfo);
        Path<?>[] paths = new Path<?>[] { userInfo.username, userInfo.displayName, userInfo.password, userInfo.email, userInfo.phone, userInfo.address };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(USERNAME, userInfo.username).map(DISPLAY_NAME, userInfo.displayName).map(PASSWORD, userInfo.password).map(EMAIL, userInfo.email).map(PHONE, userInfo.phone).map(ADDRESS, userInfo.address);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, userInfo);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<UserInfo> findByUserRole(UserRole userRole, GlobalSearch globalSearch, Pageable pageable) {
        QUserInfo userInfo = QUserInfo.userInfo;
        JPQLQuery<UserInfo> query = from(userInfo);
        Assert.notNull(userRole, "userRole is required");
        query.where(userInfo.userRole.eq(userRole));
        Path<?>[] paths = new Path<?>[] { userInfo.username, userInfo.displayName, userInfo.password, userInfo.email, userInfo.phone, userInfo.address };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(USERNAME, userInfo.username).map(DISPLAY_NAME, userInfo.displayName).map(PASSWORD, userInfo.password).map(EMAIL, userInfo.email).map(PHONE, userInfo.phone).map(ADDRESS, userInfo.address);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, userInfo);
    }
}
