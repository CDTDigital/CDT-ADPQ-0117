package com.stanfieldsystems.service.api;
import com.stanfieldsystems.UserInfo;
import org.springframework.stereotype.Service;

import com.stanfieldsystems.UserRole;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = UserInfoService
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
public interface UserInfoService {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return UserInfo
     */
    public abstract UserInfo findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     */
    public abstract void delete(UserInfo userInfo);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<UserInfo> save(Iterable<UserInfo> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return UserInfo
     */
    public abstract UserInfo save(UserInfo entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<UserInfo> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<UserInfo> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<UserInfo> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @param customerOrdersToAdd
     * @return UserInfo
     */
    public abstract UserInfo addToCustomerOrders(UserInfo userInfo, Iterable<Long> customerOrdersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @param customerOrdersToRemove
     * @return UserInfo
     */
    public abstract UserInfo removeFromCustomerOrders(UserInfo userInfo, Iterable<Long> customerOrdersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @param customerOrders
     * @return UserInfo
     */
    public abstract UserInfo setCustomerOrders(UserInfo userInfo, Iterable<Long> customerOrders);

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
     * @param userRole
     * @return Long
     */
    public abstract long countByUserRole(UserRole userRole);
}
