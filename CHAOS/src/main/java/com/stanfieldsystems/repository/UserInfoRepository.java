package com.stanfieldsystems.repository;
import com.stanfieldsystems.UserInfo;
import com.stanfieldsystems.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = UserInfoRepository
 *
 * TODO Auto-generated class documentation
 *
 */

@Transactional(readOnly = true)
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>, UserInfoRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param userRole
     * @return Long
     */
    public abstract long countByUserRole(UserRole userRole);
}
