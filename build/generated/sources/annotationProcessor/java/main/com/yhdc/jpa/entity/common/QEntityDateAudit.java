package com.yhdc.jpa.entity.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEntityDateAudit is a Querydsl query type for EntityDateAudit
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QEntityDateAudit extends EntityPathBase<EntityDateAudit> {

    private static final long serialVersionUID = -1236676468L;

    public static final QEntityDateAudit entityDateAudit = new QEntityDateAudit("entityDateAudit");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QEntityDateAudit(String variable) {
        super(EntityDateAudit.class, forVariable(variable));
    }

    public QEntityDateAudit(Path<? extends EntityDateAudit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEntityDateAudit(PathMetadata metadata) {
        super(EntityDateAudit.class, metadata);
    }

}

