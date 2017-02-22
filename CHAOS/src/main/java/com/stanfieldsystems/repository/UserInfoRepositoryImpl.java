package com.stanfieldsystems.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.stanfieldsystems.UserInfo;

/**
 * = UserInfoRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@RooJpaRepositoryCustomImpl(repository = UserInfoRepositoryCustom.class)
public class UserInfoRepositoryImpl extends QueryDslRepositorySupportExt<UserInfo> {

    /**
     * TODO Auto-generated constructor documentation
     */
    UserInfoRepositoryImpl() {
        super(UserInfo.class);
    }
}