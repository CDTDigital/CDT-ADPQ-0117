package com.stanfieldsystems.repository;
import com.stanfieldsystems.UserRole;
import org.springframework.stereotype.Repository;

import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = UserRoleRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface UserRoleRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<UserRole> findAll(GlobalSearch globalSearch, Pageable pageable);
}
