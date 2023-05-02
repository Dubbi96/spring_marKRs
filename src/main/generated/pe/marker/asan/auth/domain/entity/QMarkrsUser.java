package pe.marker.asan.auth.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMarkrsUser is a Querydsl query type for MarkrsUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMarkrsUser extends EntityPathBase<MarkrsUser> {

    private static final long serialVersionUID = 1978074188L;

    public static final QMarkrsUser markrsUser = new QMarkrsUser("markrsUser");

    public final pe.marker.asan.common.domain.entity.QBaseEntity _super = new pe.marker.asan.common.domain.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createTs = _super.createTs;

    public final StringPath email = createString("email");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> endTs = _super.endTs;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyTs = _super.modifyTs;

    public final StringPath picture = createString("picture");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final StringPath userName = createString("userName");

    public QMarkrsUser(String variable) {
        super(MarkrsUser.class, forVariable(variable));
    }

    public QMarkrsUser(Path<? extends MarkrsUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMarkrsUser(PathMetadata metadata) {
        super(MarkrsUser.class, metadata);
    }

}

