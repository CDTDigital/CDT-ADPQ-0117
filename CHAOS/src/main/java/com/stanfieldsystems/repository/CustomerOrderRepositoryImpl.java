package com.stanfieldsystems.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.stereotype.Repository;

import com.stanfieldsystems.CustomerOrder;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import com.stanfieldsystems.QCustomerOrder;
import com.stanfieldsystems.Status;
import com.stanfieldsystems.UserInfo;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = CustomerOrderRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public class CustomerOrderRepositoryImpl extends QueryDslRepositorySupportExt<CustomerOrder> implements CustomerOrderRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    CustomerOrderRepositoryImpl() {
        super(CustomerOrder.class);
    }

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String ORDER_DATE = "orderDate";

    /**
     * TODO Auto-generated field documentation
     *
     */
    private static final String TOTAL_PRICE = "totalPrice";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCustomerOrder customerOrder = QCustomerOrder.customerOrder;
        JPQLQuery<CustomerOrder> query = from(customerOrder);
        Path<?>[] paths = new Path<?>[] { customerOrder.orderDate, customerOrder.totalPrice };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ORDER_DATE, customerOrder.orderDate).map(TOTAL_PRICE, customerOrder.totalPrice);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerOrder);
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
        QCustomerOrder customerOrder = QCustomerOrder.customerOrder;
        JPQLQuery<CustomerOrder> query = from(customerOrder);
        Assert.notNull(status, "status is required");
        query.where(customerOrder.status.eq(status));
        Path<?>[] paths = new Path<?>[] { customerOrder.orderDate, customerOrder.totalPrice };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ORDER_DATE, customerOrder.orderDate).map(TOTAL_PRICE, customerOrder.totalPrice);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerOrder);
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
        QCustomerOrder customerOrder = QCustomerOrder.customerOrder;
        JPQLQuery<CustomerOrder> query = from(customerOrder);
        Assert.notNull(userInfo, "userInfo is required");
        query.where(customerOrder.userInfo.eq(userInfo));
        Path<?>[] paths = new Path<?>[] { customerOrder.orderDate, customerOrder.totalPrice };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ORDER_DATE, customerOrder.orderDate).map(TOTAL_PRICE, customerOrder.totalPrice);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerOrder);
    }
}
