package com.stanfieldsystems.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.stereotype.Repository;

import com.stanfieldsystems.OrderProduct;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.QOrderProduct;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = OrderProductRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public class OrderProductRepositoryImpl extends QueryDslRepositorySupportExt<OrderProduct> implements OrderProductRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    OrderProductRepositoryImpl() {
        super(OrderProduct.class);
    }

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String PRICE = "price";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String QUANTITY = "quantity";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderProduct> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QOrderProduct orderProduct = QOrderProduct.orderProduct;
        JPQLQuery<OrderProduct> query = from(orderProduct);
        Path<?>[] paths = new Path<?>[] { orderProduct.quantity, orderProduct.price };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(QUANTITY, orderProduct.quantity).map(PRICE, orderProduct.price);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, orderProduct);
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
        QOrderProduct orderProduct = QOrderProduct.orderProduct;
        JPQLQuery<OrderProduct> query = from(orderProduct);
        Assert.notNull(customerOrder, "customerOrder is required");
        query.where(orderProduct.customerOrder.eq(customerOrder));
        Path<?>[] paths = new Path<?>[] { orderProduct.quantity, orderProduct.price };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(QUANTITY, orderProduct.quantity).map(PRICE, orderProduct.price);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, orderProduct);
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
        QOrderProduct orderProduct = QOrderProduct.orderProduct;
        JPQLQuery<OrderProduct> query = from(orderProduct);
        Assert.notNull(product, "product is required");
        query.where(orderProduct.product.eq(product));
        Path<?>[] paths = new Path<?>[] { orderProduct.quantity, orderProduct.price };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(QUANTITY, orderProduct.quantity).map(PRICE, orderProduct.price);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, orderProduct);
    }
}
