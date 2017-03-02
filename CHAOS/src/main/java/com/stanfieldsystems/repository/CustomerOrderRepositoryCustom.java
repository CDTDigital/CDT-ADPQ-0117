package com.stanfieldsystems.repository;
import com.stanfieldsystems.CustomerOrder;
import org.springframework.stereotype.Repository;

import com.stanfieldsystems.Status;
import com.stanfieldsystems.UserInfo;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CustomerOrderRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface CustomerOrderRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerOrder> findByUserInfo(UserInfo userInfo, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerOrder> findByStatus(Status status, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerOrder> findAll(GlobalSearch globalSearch, Pageable pageable);
}
