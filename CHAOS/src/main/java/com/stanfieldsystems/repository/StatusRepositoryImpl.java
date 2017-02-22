package com.stanfieldsystems.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.stanfieldsystems.Status;

/**
 * = StatusRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@RooJpaRepositoryCustomImpl(repository = StatusRepositoryCustom.class)
public class StatusRepositoryImpl extends QueryDslRepositorySupportExt<Status> {

    /**
     * TODO Auto-generated constructor documentation
     */
    StatusRepositoryImpl() {
        super(Status.class);
    }
}