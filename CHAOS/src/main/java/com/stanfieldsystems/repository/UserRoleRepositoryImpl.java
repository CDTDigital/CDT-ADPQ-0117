package com.stanfieldsystems.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.stanfieldsystems.UserRole;

/**
 * = UserRoleRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@RooJpaRepositoryCustomImpl(repository = UserRoleRepositoryCustom.class)
public class UserRoleRepositoryImpl extends QueryDslRepositorySupportExt<UserRole> {

    /**
     * TODO Auto-generated constructor documentation
     */
    UserRoleRepositoryImpl() {
        super(UserRole.class);
    }
}