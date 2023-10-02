package pe.veriestate.asan.code.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodeGroupJpaEntity is a Querydsl query type for CodeGroupJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeGroupJpaEntity extends EntityPathBase<CodeGroupJpaEntity> {

    private static final long serialVersionUID = 1529375714L;

    public static final QCodeGroupJpaEntity codeGroupJpaEntity = new QCodeGroupJpaEntity("codeGroupJpaEntity");

    public final DateTimePath<java.time.LocalDateTime> deleted = createDateTime("deleted", java.time.LocalDateTime.class);

    public final StringPath description = createString("description");

    public final StringPath displayId = createString("displayId");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QCodeGroupJpaEntity(String variable) {
        super(CodeGroupJpaEntity.class, forVariable(variable));
    }

    public QCodeGroupJpaEntity(Path<? extends CodeGroupJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodeGroupJpaEntity(PathMetadata metadata) {
        super(CodeGroupJpaEntity.class, metadata);
    }

}

