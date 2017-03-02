package com.stanfieldsystems.service.api;
import com.stanfieldsystems.Status;
import org.springframework.stereotype.Service;

import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = StatusService
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
public interface StatusService {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Status
     */
    public abstract Status findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     */
    public abstract void delete(Status status);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Status> save(Iterable<Status> entities);

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
     * @return Status
     */
    public abstract Status save(Status entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Status> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Status> findAll();

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
    public abstract Page<Status> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param customerOrdersToAdd
     * @return Status
     */
    public abstract Status addToCustomerOrders(Status status, Iterable<Long> customerOrdersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param customerOrdersToRemove
     * @return Status
     */
    public abstract Status removeFromCustomerOrders(Status status, Iterable<Long> customerOrdersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param customerOrders
     * @return Status
     */
    public abstract Status setCustomerOrders(Status status, Iterable<Long> customerOrders);
}
