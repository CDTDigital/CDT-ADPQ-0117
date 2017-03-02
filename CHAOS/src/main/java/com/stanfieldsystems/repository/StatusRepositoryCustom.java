package com.stanfieldsystems.repository;
import com.stanfieldsystems.Status;
import org.springframework.stereotype.Repository;

import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = StatusRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface StatusRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Status> findAll(GlobalSearch globalSearch, Pageable pageable);
}
