package com.stanfieldsystems;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserRole is a Querydsl query type for UserRole
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserRole extends EntityPathBase<UserRole> {

    private static final long serialVersionUID = 1395036874L;

    public static final QUserRole userRole = new QUserRole("userRole");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<UserInfo, QUserInfo> userInfos = this.<UserInfo, QUserInfo>createSet("userInfos", UserInfo.class, QUserInfo.class, PathInits.DIRECT2);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QUserRole(String variable) {
        super(UserRole.class, forVariable(variable));
    }

    public QUserRole(Path<? extends UserRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserRole(PathMetadata metadata) {
        super(UserRole.class, metadata);
    }

}
