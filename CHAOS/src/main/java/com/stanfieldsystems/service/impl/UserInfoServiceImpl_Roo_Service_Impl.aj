// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.stanfieldsystems.service.impl;

import com.stanfieldsystems.CustomerOrder;
import com.stanfieldsystems.UserInfo;
import com.stanfieldsystems.UserRole;
import com.stanfieldsystems.repository.UserInfoRepository;
import com.stanfieldsystems.service.api.CustomerOrderService;
import com.stanfieldsystems.service.api.UserInfoService;
import com.stanfieldsystems.service.impl.UserInfoServiceImpl;
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

privileged aspect UserInfoServiceImpl_Roo_Service_Impl {
    
    declare parents: UserInfoServiceImpl implements UserInfoService;
    
    declare @type: UserInfoServiceImpl: @Service;
    
    declare @type: UserInfoServiceImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated attribute documentation
     */
    private UserInfoRepository UserInfoServiceImpl.userInfoRepository;
    
    /**
     * TODO Auto-generated attribute documentation
     */
    private CustomerOrderService UserInfoServiceImpl.customerOrderService;
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param userInfoRepository
     * @param customerOrderService
     */
    @Autowired
    public UserInfoServiceImpl.new(UserInfoRepository userInfoRepository, @Lazy CustomerOrderService customerOrderService) {
        this.userInfoRepository = userInfoRepository;
        this.customerOrderService = customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @param userInfo
     * @param customerOrdersToAdd
     * @return UserInfo
     */
    @Transactional
    public UserInfo UserInfoServiceImpl.addToCustomerOrders(UserInfo userInfo, Iterable<Long> customerOrdersToAdd) {
        List<CustomerOrder> customerOrders = customerOrderService.findAll(customerOrdersToAdd);
        userInfo.addToCustomerOrders(customerOrders);
        return userInfoRepository.save(userInfo);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param userInfo
     * @param customerOrdersToRemove
     * @return UserInfo
     */
    @Transactional
    public UserInfo UserInfoServiceImpl.removeFromCustomerOrders(UserInfo userInfo, Iterable<Long> customerOrdersToRemove) {
        List<CustomerOrder> customerOrders = customerOrderService.findAll(customerOrdersToRemove);
        userInfo.removeFromCustomerOrders(customerOrders);
        return userInfoRepository.save(userInfo);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param userInfo
     * @param customerOrders
     * @return UserInfo
     */
    @Transactional
    public UserInfo UserInfoServiceImpl.setCustomerOrders(UserInfo userInfo, Iterable<Long> customerOrders) {
        List<CustomerOrder> items = customerOrderService.findAll(customerOrders);
        Set<CustomerOrder> currents = userInfo.getCustomerOrders();
        Set<CustomerOrder> toRemove = new HashSet<CustomerOrder>();
        for (Iterator<CustomerOrder> iterator = currents.iterator(); iterator.hasNext();) {
            CustomerOrder nextCustomerOrder = iterator.next();
            if (items.contains(nextCustomerOrder)) {
                items.remove(nextCustomerOrder);
            } else {
                toRemove.add(nextCustomerOrder);
            }
        }
        userInfo.removeFromCustomerOrders(toRemove);
        userInfo.addToCustomerOrders(items);
        return userInfoRepository.save(userInfo);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param userInfo
     */
    @Transactional
    public void UserInfoServiceImpl.delete(UserInfo userInfo) {
        // Clear bidirectional many-to-one child relationship with UserRole
        if (userInfo.getUserRole() != null) {
            userInfo.getUserRole().getUserInfos().remove(userInfo);
        }
        
        // Clear bidirectional one-to-many parent relationship with CustomerOrder
        for (CustomerOrder item : userInfo.getCustomerOrders()) {
            item.setUserInfo(null);
        }
        
        userInfoRepository.delete(userInfo);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    @Transactional
    public List<UserInfo> UserInfoServiceImpl.save(Iterable<UserInfo> entities) {
        return userInfoRepository.save(entities);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    @Transactional
    public void UserInfoServiceImpl.delete(Iterable<Long> ids) {
        List<UserInfo> toDelete = userInfoRepository.findAll(ids);
        userInfoRepository.deleteInBatch(toDelete);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return UserInfo
     */
    @Transactional
    public UserInfo UserInfoServiceImpl.save(UserInfo entity) {
        return userInfoRepository.save(entity);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return UserInfo
     */
    public UserInfo UserInfoServiceImpl.findOne(Long id) {
        return userInfoRepository.findOne(id);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public List<UserInfo> UserInfoServiceImpl.findAll(Iterable<Long> ids) {
        return userInfoRepository.findAll(ids);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public List<UserInfo> UserInfoServiceImpl.findAll() {
        return userInfoRepository.findAll();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public long UserInfoServiceImpl.count() {
        return userInfoRepository.count();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<UserInfo> UserInfoServiceImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        return userInfoRepository.findAll(globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param userRole
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<UserInfo> UserInfoServiceImpl.findByUserRole(UserRole userRole, GlobalSearch globalSearch, Pageable pageable) {
        return userInfoRepository.findByUserRole(userRole, globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param userRole
     * @return Long
     */
    public long UserInfoServiceImpl.countByUserRole(UserRole userRole) {
        return userInfoRepository.countByUserRole(userRole);
    }
    
}
