package com.stanfieldsystems.repository;
import com.stanfieldsystems.OrderProduct;
import org.springframework.stereotype.Repository;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = OrderProductRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>, OrderProductRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Long
     */
    public abstract long countByProduct(Product product);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @return Long
     */
    public abstract long countByCustomerOrder(CustomerOrder customerOrder);
}
