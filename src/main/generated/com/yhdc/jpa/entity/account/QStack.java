package com.yhdc.jpa.entity.account;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStack is a Querydsl query type for Stack
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStack extends EntityPathBase<Stack> {

    private static final long serialVersionUID = -1194305726L;

    public static final QStack stack = new QStack("stack");

    public final com.yhdc.jpa.entity.common.QEntityDateAudit _super = new com.yhdc.jpa.entity.common.QEntityDateAudit(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath level = createString("level");

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final SetPath<User, QUser> userSet = this.<User, QUser>createSet("userSet", User.class, QUser.class, PathInits.DIRECT2);

    public QStack(String variable) {
        super(Stack.class, forVariable(variable));
    }

    public QStack(Path<? extends Stack> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStack(PathMetadata metadata) {
        super(Stack.class, metadata);
    }

}

