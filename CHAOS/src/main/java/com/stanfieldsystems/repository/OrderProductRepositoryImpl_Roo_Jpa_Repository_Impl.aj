// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stanfieldsystems.repository;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.QOrderProduct;
import com.stanfieldsystems.repository.OrderProductRepositoryCustom;
import com.stanfieldsystems.repository.OrderProductRepositoryImpl;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

privileged aspect OrderProductRepositoryImpl_Roo_Jpa_Repository_Impl {
    
    declare parents: OrderProductRepositoryImpl implements OrderProductRepositoryCustom;
    
    declare @type: OrderProductRepositoryImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated attribute documentation
     */
    private static final String OrderProductRepositoryImpl.NAME = "name";
    
    /**
     * TODO Auto-generated attribute documentation
     */
    private static final String OrderProductRepositoryImpl.QUANTITY = "quantity";
    
    /**
     * TODO Auto-generated attribute documentation
     */
    private static final String OrderProductRepositoryImpl.PRICE = "price";
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderProduct> OrderProductRepositoryImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        
        QOrderProduct orderProduct = QOrderProduct.orderProduct;
        
        JPQLQuery<OrderProduct> query = from(orderProduct);
        
        Path<?>[] paths = new Path<?>[] {orderProduct.name,orderProduct.quantity,orderProduct.price};        
        applyGlobalSearch(globalSearch, query, paths);
        
        AttributeMappingBuilder mapping = buildMapper()
			.map(NAME, orderProduct.name)
			.map(QUANTITY, orderProduct.quantity)
			.map(PRICE, orderProduct.price);
        
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
    public Page<OrderProduct> OrderProductRepositoryImpl.findByCustomerOrder(CustomerOrder customerOrder, GlobalSearch globalSearch, Pageable pageable) {
        
        QOrderProduct orderProduct = QOrderProduct.orderProduct;
        
        JPQLQuery<OrderProduct> query = from(orderProduct);
        
        Assert.notNull(customerOrder, "customerOrder is required");
        
        query.where(orderProduct.customerOrder.eq(customerOrder));
        Path<?>[] paths = new Path<?>[] {orderProduct.name,orderProduct.quantity,orderProduct.price};        
        applyGlobalSearch(globalSearch, query, paths);
        
        AttributeMappingBuilder mapping = buildMapper()
			.map(NAME, orderProduct.name)
			.map(QUANTITY, orderProduct.quantity)
			.map(PRICE, orderProduct.price);
        
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
    public Page<OrderProduct> OrderProductRepositoryImpl.findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable) {
        
        QOrderProduct orderProduct = QOrderProduct.orderProduct;
        
        JPQLQuery<OrderProduct> query = from(orderProduct);
        
        Assert.notNull(product, "product is required");
        
        query.where(orderProduct.product.eq(product));
        Path<?>[] paths = new Path<?>[] {orderProduct.name,orderProduct.quantity,orderProduct.price};        
        applyGlobalSearch(globalSearch, query, paths);
        
        AttributeMappingBuilder mapping = buildMapper()
			.map(NAME, orderProduct.name)
			.map(QUANTITY, orderProduct.quantity)
			.map(PRICE, orderProduct.price);
        
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        
        return loadPage(query, pageable, orderProduct);
    }
    
}
