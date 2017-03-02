package com.stanfieldsystems.service.impl;
import com.stanfieldsystems.service.api.OrderProductService;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.repository.OrderProductRepository;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = OrderProductServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */

@Service
@Transactional(readOnly = true)
public class OrderProductServiceImpl implements OrderProductService {

    /**
     * TODO Auto-generated field documentation
     *
     */
    private OrderProductRepository orderProductRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderProductRepository
     */
    @Autowired
    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderProduct
     */
    @Transactional
    public void delete(OrderProduct orderProduct) {
        // Clear bidirectional many-to-one child relationship with Product
        if (orderProduct.getProduct() != null) {
            orderProduct.getProduct().getOrderProducts().remove(orderProduct);
        }
        // Clear bidirectional many-to-one child relationship with CustomerOrder
        if (orderProduct.getCustomerOrder() != null) {
            orderProduct.getCustomerOrder().getOrderProducts().remove(orderProduct);
        }
        orderProductRepository.delete(orderProduct);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<OrderProduct> save(Iterable<OrderProduct> entities) {
        return orderProductRepository.save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<OrderProduct> toDelete = orderProductRepository.findAll(ids);
        orderProductRepository.deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return OrderProduct
     */
    @Transactional
    public OrderProduct save(OrderProduct entity) {
        return orderProductRepository.save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return OrderProduct
     */
    public OrderProduct findOne(Long id) {
        return orderProductRepository.findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<OrderProduct> findAll(Iterable<Long> ids) {
        return orderProductRepository.findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<OrderProduct> findAll() {
        return orderProductRepository.findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return orderProductRepository.count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderProduct> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return orderProductRepository.findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderProduct> findByCustomerOrder(CustomerOrder customerOrder, GlobalSearch globalSearch, Pageable pageable) {
        return orderProductRepository.findByCustomerOrder(customerOrder, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderProduct> findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable) {
        return orderProductRepository.findByProduct(product, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @return Long
     */
    public long countByCustomerOrder(CustomerOrder customerOrder) {
        return orderProductRepository.countByCustomerOrder(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Long
     */
    public long countByProduct(Product product) {
        return orderProductRepository.countByProduct(product);
    }
}
