package com.stanfieldsystems.repository;
import com.stanfieldsystems.UserRole;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = UserRoleRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>, UserRoleRepositoryCustom {
}
