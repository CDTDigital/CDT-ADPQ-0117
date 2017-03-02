package com.stanfieldsystems.repository;
import com.stanfieldsystems.OrderProduct;
import org.springframework.stereotype.Repository;

import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.Product;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = OrderProductRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface OrderProductRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderProduct> findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderProduct> findByCustomerOrder(CustomerOrder customerOrder, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderProduct> findAll(GlobalSearch globalSearch, Pageable pageable);
}
