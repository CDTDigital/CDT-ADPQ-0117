package com.stanfieldsystems.service.impl;
import com.stanfieldsystems.service.api.StatusService;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.Status;
import com.stanfieldsystems.repository.StatusRepository;
import com.stanfieldsystems.service.api.CustomerOrderService;
import io.springlets.data.domain.GlobalSearch;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = StatusServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */

@Service
@Transactional(readOnly = true)
public class StatusServiceImpl implements StatusService {

    /**
     * TODO Auto-generated field documentation
     *
     */
    private CustomerOrderService customerOrderService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private StatusRepository statusRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param statusRepository
     * @param customerOrderService
     */
    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository, @Lazy CustomerOrderService customerOrderService) {
        this.statusRepository = statusRepository;
        this.customerOrderService = customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param customerOrdersToAdd
     * @return Status
     */
    @Transactional
    public Status addToCustomerOrders(Status status, Iterable<Long> customerOrdersToAdd) {
        List<CustomerOrder> customerOrders = customerOrderService.findAll(customerOrdersToAdd);
        status.addToCustomerOrders(customerOrders);
        return statusRepository.save(status);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param customerOrdersToRemove
     * @return Status
     */
    @Transactional
    public Status removeFromCustomerOrders(Status status, Iterable<Long> customerOrdersToRemove) {
        List<CustomerOrder> customerOrders = customerOrderService.findAll(customerOrdersToRemove);
        status.removeFromCustomerOrders(customerOrders);
        return statusRepository.save(status);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param customerOrders
     * @return Status
     */
    @Transactional
    public Status setCustomerOrders(Status status, Iterable<Long> customerOrders) {
        List<CustomerOrder> items = customerOrderService.findAll(customerOrders);
        Set<CustomerOrder> currents = status.getCustomerOrders();
        Set<CustomerOrder> toRemove = new HashSet<CustomerOrder>();
        for (Iterator<CustomerOrder> iterator = currents.iterator(); iterator.hasNext(); ) {
            CustomerOrder nextCustomerOrder = iterator.next();
            if (items.contains(nextCustomerOrder)) {
                items.remove(nextCustomerOrder);
            } else {
                toRemove.add(nextCustomerOrder);
            }
        }
        status.removeFromCustomerOrders(toRemove);
        status.addToCustomerOrders(items);
        return statusRepository.save(status);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     */
    @Transactional
    public void delete(Status status) {
        // Clear bidirectional one-to-many parent relationship with CustomerOrder
        for (CustomerOrder item : status.getCustomerOrders()) {
            item.setStatus(null);
        }
        statusRepository.delete(status);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Status> save(Iterable<Status> entities) {
        return statusRepository.save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Status> toDelete = statusRepository.findAll(ids);
        statusRepository.deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Status
     */
    @Transactional
    public Status save(Status entity) {
        return statusRepository.save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Status
     */
    public Status findOne(Long id) {
        return statusRepository.findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Status> findAll(Iterable<Long> ids) {
        return statusRepository.findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return statusRepository.count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Status> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return statusRepository.findAll(globalSearch, pageable);
    }
}
