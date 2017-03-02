package com.stanfieldsystems.repository;
import com.stanfieldsystems.Status;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = StatusRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long>, StatusRepositoryCustom {
}
