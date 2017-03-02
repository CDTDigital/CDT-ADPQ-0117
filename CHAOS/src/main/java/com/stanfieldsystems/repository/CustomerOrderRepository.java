package com.stanfieldsystems.repository;
import com.stanfieldsystems.CustomerOrder;
import org.springframework.stereotype.Repository;
import com.stanfieldsystems.Status;
import com.stanfieldsystems.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerOrderRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long>, CustomerOrderRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param userInfo
     * @return Long
     */
    public abstract long countByUserInfo(UserInfo userInfo);

    /**
     * TODO Auto-generated method documentation
     *
     * @param status
     * @return Long
     */
    public abstract long countByStatus(Status status);
}
