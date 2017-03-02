package com.stanfieldsystems.service.impl;
import com.stanfieldsystems.service.api.UserRoleService;
import com.stanfieldsystems.UserInfo;
import com.stanfieldsystems.UserRole;
import com.stanfieldsystems.repository.UserRoleRepository;
import com.stanfieldsystems.service.api.UserInfoService;
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
 * = UserRoleServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */

@Service
@Transactional(readOnly = true)
public class UserRoleServiceImpl implements UserRoleService {

    /**
     * TODO Auto-generated field documentation
     *
     */
    private UserInfoService userInfoService;

    /**
     * TODO Auto-generated field documentation
     *
     */
    private UserRoleRepository userRoleRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param userRoleRepository
     * @param userInfoService
     */
    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, @Lazy UserInfoService userInfoService) {
        this.userRoleRepository = userRoleRepository;
        this.userInfoService = userInfoService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param userInfosToAdd
     * @return UserRole
     */
    @Transactional
    public UserRole addToUserInfos(UserRole userRole, Iterable<Long> userInfosToAdd) {
        List<UserInfo> userInfos = userInfoService.findAll(userInfosToAdd);
        userRole.addToUserInfos(userInfos);
        return userRoleRepository.save(userRole);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param userInfosToRemove
     * @return UserRole
     */
    @Transactional
    public UserRole removeFromUserInfos(UserRole userRole, Iterable<Long> userInfosToRemove) {
        List<UserInfo> userInfos = userInfoService.findAll(userInfosToRemove);
        userRole.removeFromUserInfos(userInfos);
        return userRoleRepository.save(userRole);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param userInfos
     * @return UserRole
     */
    @Transactional
    public UserRole setUserInfos(UserRole userRole, Iterable<Long> userInfos) {
        List<UserInfo> items = userInfoService.findAll(userInfos);
        Set<UserInfo> currents = userRole.getUserInfos();
        Set<UserInfo> toRemove = new HashSet<UserInfo>();
        for (Iterator<UserInfo> iterator = currents.iterator(); iterator.hasNext(); ) {
            UserInfo nextUserInfo = iterator.next();
            if (items.contains(nextUserInfo)) {
                items.remove(nextUserInfo);
            } else {
                toRemove.add(nextUserInfo);
            }
        }
        userRole.removeFromUserInfos(toRemove);
        userRole.addToUserInfos(items);
        return userRoleRepository.save(userRole);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     */
    @Transactional
    public void delete(UserRole userRole) {
        // Clear bidirectional one-to-many parent relationship with UserInfo
        for (UserInfo item : userRole.getUserInfos()) {
            item.setUserRole(null);
        }
        userRoleRepository.delete(userRole);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<UserRole> save(Iterable<UserRole> entities) {
        return userRoleRepository.save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<UserRole> toDelete = userRoleRepository.findAll(ids);
        userRoleRepository.deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return UserRole
     */
    @Transactional
    public UserRole save(UserRole entity) {
        return userRoleRepository.save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return UserRole
     */
    public UserRole findOne(Long id) {
        return userRoleRepository.findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<UserRole> findAll(Iterable<Long> ids) {
        return userRoleRepository.findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return userRoleRepository.count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<UserRole> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return userRoleRepository.findAll(globalSearch, pageable);
    }
}
