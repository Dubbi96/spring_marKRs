package pe.veriestate.asan.property.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRealEstateAgencyInfo is a Querydsl query type for RealEstateAgencyInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRealEstateAgencyInfo extends EntityPathBase<RealEstateAgencyInfo> {

    private static final long serialVersionUID = 815643851L;

    public static final QRealEstateAgencyInfo realEstateAgencyInfo = new QRealEstateAgencyInfo("realEstateAgencyInfo");

    public final pe.veriestate.asan.common.domain.entity.QBaseEntity _super = new pe.veriestate.asan.common.domain.entity.QBaseEntity(this);

    public final StringPath agencyName = createString("agencyName");

    public final StringPath agentName = createString("agentName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createTs = _super.createTs;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> endTs = _super.endTs;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath location = createString("location");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyTs = _super.modifyTs;

    public final StringPath phone = createString("phone");

    public final StringPath registrationNumber = createString("registrationNumber");

    public QRealEstateAgencyInfo(String variable) {
        super(RealEstateAgencyInfo.class, forVariable(variable));
    }

    public QRealEstateAgencyInfo(Path<? extends RealEstateAgencyInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRealEstateAgencyInfo(PathMetadata metadata) {
        super(RealEstateAgencyInfo.class, metadata);
    }

}

