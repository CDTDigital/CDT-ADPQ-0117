package com.stanfieldsystems.service.impl;

import com.stanfieldsystems.service.api.CustomerOrderService;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.Status;
import com.stanfieldsystems.UserInfo;
import com.stanfieldsystems.repository.CustomerOrderRepository;
import com.stanfieldsystems.service.api.OrderProductService;
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
 * = CustomerOrderServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */

@Service
@Transactional(readOnly = true)
public class CustomerOrderServiceImpl implements CustomerOrderService {

    /**
     * TODO Auto-generated field documentation
     *
     */
    private OrderProductService orderProductService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private CustomerOrderRepository customerOrderRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerOrderRepository
     * @param orderProductService
     */
    @Autowired
    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository, @Lazy OrderProductService orderProductService) {
        this.customerOrderRepository = customerOrderRepository;
        this.orderProductService = orderProductService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderProductsToAdd
     * @return CustomerOrder
     */
    @Transactional
    public CustomerOrder addToOrderProducts(CustomerOrder customerOrder, Iterable<Long> orderProductsToAdd) {
        List<OrderProduct> orderProducts = orderProductService.findAll(orderProductsToAdd);
        customerOrder.addToOrderProducts(orderProducts);
        return customerOrderRepository.save(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderProductsToRemove
     * @return CustomerOrder
     */
    @Transactional
    public CustomerOrder removeFromOrderProducts(CustomerOrder customerOrder, Iterable<Long> orderProductsToRemove) {
        List<OrderProduct> orderProducts = orderProductService.findAll(orderProductsToRemove);
        customerOrder.removeFromOrderProducts(orderProducts);
        return customerOrderRepository.save(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderProducts
     * @return CustomerOrder
     */
    @Transactional
    public CustomerOrder setOrderProducts(CustomerOrder customerOrder, Iterable<Long> orderProducts) {
        List<OrderProduct> items = orderProductService.findAll(orderProducts);
        Set<OrderProduct> currents = customerOrder.getOrderProducts();
        Set<OrderProduct> toRemove = new HashSet<OrderProduct>();
        for (Iterator<OrderProduct> iterator = currents.iterator(); iterator.hasNext(); ) {
            OrderProduct nextOrderProduct = iterator.next();
            if (items.contains(nextOrderProduct)) {
                items.remove(nextOrderProduct);
            } else {
                toRemove.add(nextOrderProduct);
            }
        }
        customerOrder.removeFromOrderProducts(toRemove);
        customerOrder.addToOrderProducts(items);
        return customerOrderRepository.save(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     */
    @Transactional
    public void delete(CustomerOrder customerOrder) {
        // Clear bidirectional many-to-one child relationship with UserInfo
        if (customerOrder.getUserInfo() != null) {
            customerOrder.getUserInfo().getCustomerOrders().remove(customerOrder);
        }
        // Clear bidirectional many-to-one child relationship with Status
        if (customerOrder.getStatus() != null) {
            customerOrder.getStatus().getCustomerOrders().remove(customerOrder);
        }
        // Clear bidirectional one-to-many parent relationship with OrderProduct
        for (OrderProduct item : customerOrder.getOrderProducts()) {
            item.setCustomerOrder(null);
        }
        customerOrderRepository.delete(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<CustomerOrder> save(Iterable<CustomerOrder> entities) {
        return customerOrderRepository.save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<CustomerOrder> toDelete = customerOrderRepository.findAll(ids);
        customerOrderRepository.deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return CustomerOrder
     */
    @Transactional
    public CustomerOrder save(CustomerOrder entity) {
        return customerOrderRepository.save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return CustomerOrder
     */
    public CustomerOrder findOne(Long id) {
        return customerOrderRepository.findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<CustomerOrder> findAll(Iterable<Long> ids) {
        return customerOrderRepository.findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<CustomerOrder> findAll() {
        return customerOrderRepository.findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return customerOrderRepository.count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return customerOrderRepository.findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findByStatus(Status status, GlobalSearch globalSearch, Pageable pageable) {
        return customerOrderRepository.findByStatus(status, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findByUserInfo(UserInfo userInfo, GlobalSearch globalSearch, Pageable pageable) {
        return customerOrderRepository.findByUserInfo(userInfo, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @return Long
     */
    public long countByStatus(Status status) {
        return customerOrderRepository.countByStatus(status);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @return Long
     */
    public long countByUserInfo(UserInfo userInfo) {
        return customerOrderRepository.countByUserInfo(userInfo);
    }
}
