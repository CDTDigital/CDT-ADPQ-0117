package com.dbtest.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.dbtest.HelloDb;

/**
 * = HelloDbRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@RooJpaRepositoryCustomImpl(repository = HelloDbRepositoryCustom.class)
public class HelloDbRepositoryImpl extends QueryDslRepositorySupportExt<HelloDb> {

    /**
     * TODO Auto-generated constructor documentation
     */
    HelloDbRepositoryImpl() {
        super(HelloDb.class);
    }
}