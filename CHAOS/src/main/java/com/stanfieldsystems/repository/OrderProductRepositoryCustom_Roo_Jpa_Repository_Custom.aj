// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stanfieldsystems.repository;

import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.OrderProduct;
import com.stanfieldsystems.Product;
import com.stanfieldsystems.repository.OrderProductRepositoryCustom;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

privileged aspect OrderProductRepositoryCustom_Roo_Jpa_Repository_Custom {
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderProduct> OrderProductRepositoryCustom.findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customerOrder
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderProduct> OrderProductRepositoryCustom.findByCustomerOrder(CustomerOrder customerOrder, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderProduct> OrderProductRepositoryCustom.findAll(GlobalSearch globalSearch, Pageable pageable);
    
}
