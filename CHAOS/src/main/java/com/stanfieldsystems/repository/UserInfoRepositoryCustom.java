package com.stanfieldsystems.repository;
import com.stanfieldsystems.UserInfo;
import org.springframework.stereotype.Repository;

import com.stanfieldsystems.UserRole;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = UserInfoRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface UserInfoRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<UserInfo> findByUserRole(UserRole userRole, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<UserInfo> findAll(GlobalSearch globalSearch, Pageable pageable);
}
