package pe.marker.asan.auth.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVeriEstateUser is a Querydsl query type for VeriEstateUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVeriEstateUser extends EntityPathBase<VeriEstateUser> {

    private static final long serialVersionUID = -331871472L;

    public static final QVeriEstateUser veriEstateUser = new QVeriEstateUser("veriEstateUser");

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

    public final StringPath nickname = createString("nickname");

    public final StringPath picture = createString("picture");

    public final StringPath provider = createString("provider");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final StringPath userName = createString("userName");

    public QVeriEstateUser(String variable) {
        super(VeriEstateUser.class, forVariable(variable));
    }

    public QVeriEstateUser(Path<? extends VeriEstateUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVeriEstateUser(PathMetadata metadata) {
        super(VeriEstateUser.class, metadata);
    }

}

