package com.stanfieldsystems.service.api;
import com.stanfieldsystems.CustomerOrder;
import org.springframework.stereotype.Service;

import com.stanfieldsystems.Status;
import com.stanfieldsystems.UserInfo;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CustomerOrderService
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
public interface CustomerOrderService {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return CustomerOrder
     */
    public abstract CustomerOrder findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     */
    public abstract void delete(CustomerOrder customerOrder);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<CustomerOrder> save(Iterable<CustomerOrder> entities);

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
     * @return CustomerOrder
     */
    public abstract CustomerOrder save(CustomerOrder entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<CustomerOrder> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<CustomerOrder> findAll();

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
    public abstract Page<CustomerOrder> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderProductsToAdd
     * @return CustomerOrder
     */
    public abstract CustomerOrder addToOrderProducts(CustomerOrder customerOrder, Iterable<Long> orderProductsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderProductsToRemove
     * @return CustomerOrder
     */
    public abstract CustomerOrder removeFromOrderProducts(CustomerOrder customerOrder, Iterable<Long> orderProductsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderProducts
     * @return CustomerOrder
     */
    public abstract CustomerOrder setOrderProducts(CustomerOrder customerOrder, Iterable<Long> orderProducts);

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
     * @return Long
     */
    public abstract long countByStatus(Status status);

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @return Long
     */
    public abstract long countByUserInfo(UserInfo userInfo);
}
