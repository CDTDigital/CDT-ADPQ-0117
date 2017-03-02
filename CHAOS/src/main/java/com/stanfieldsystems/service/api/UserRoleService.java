package com.stanfieldsystems.service.api;
import com.stanfieldsystems.UserRole;
import org.springframework.stereotype.Service;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = UserRoleService
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
public interface UserRoleService {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return UserRole
     */
    public abstract UserRole findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     */
    public abstract void delete(UserRole userRole);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<UserRole> save(Iterable<UserRole> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return UserRole
     */
    public abstract UserRole save(UserRole entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<UserRole> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<UserRole> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<UserRole> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param userInfosToAdd
     * @return UserRole
     */
    public abstract UserRole addToUserInfos(UserRole userRole, Iterable<Long> userInfosToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param userInfosToRemove
     * @return UserRole
     */
    public abstract UserRole removeFromUserInfos(UserRole userRole, Iterable<Long> userInfosToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @param userInfos
     * @return UserRole
     */
    public abstract UserRole setUserInfos(UserRole userRole, Iterable<Long> userInfos);
}
