package pe.veriestate.asan.code.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCodeJpaEntity is a Querydsl query type for CodeJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeJpaEntity extends EntityPathBase<CodeJpaEntity> {

    private static final long serialVersionUID = 1945378235L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCodeJpaEntity codeJpaEntity = new QCodeJpaEntity("codeJpaEntity");

    public final QCodeGroupJpaEntity codeGroup;

    public final DateTimePath<java.time.LocalDateTime> deleted = createDateTime("deleted", java.time.LocalDateTime.class);

    public final StringPath description = createString("description");

    public final StringPath displayId = createString("displayId");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> position = createNumber("position", Integer.class);

    public QCodeJpaEntity(String variable) {
        this(CodeJpaEntity.class, forVariable(variable), INITS);
    }

    public QCodeJpaEntity(Path<? extends CodeJpaEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCodeJpaEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCodeJpaEntity(PathMetadata metadata, PathInits inits) {
        this(CodeJpaEntity.class, metadata, inits);
    }

    public QCodeJpaEntity(Class<? extends CodeJpaEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.codeGroup = inits.isInitialized("codeGroup") ? new QCodeGroupJpaEntity(forProperty("codeGroup")) : null;
    }

}

