package pe.veriestate.asan.property.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProperty is a Querydsl query type for Property
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProperty extends EntityPathBase<Property> {

    private static final long serialVersionUID = 2091035427L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProperty property = new QProperty("property");

    public final pe.veriestate.asan.common.domain.entity.QBaseEntity _super = new pe.veriestate.asan.common.domain.entity.QBaseEntity(this);

    public final QRealEstateAgencyInfo agencyInfo;

    public final DatePath<java.time.LocalDate> approvalDate = createDate("approvalDate", java.time.LocalDate.class);

    public final NumberPath<Long> areaSqm = createNumber("areaSqm", Long.class);

    public final DatePath<java.time.LocalDate> availableDate = createDate("availableDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createTs = _super.createTs;

    public final NumberPath<Long> depositeAmount = createNumber("depositeAmount", Long.class);

    public final StringPath direction = createString("direction");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> endTs = _super.endTs;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath location = createString("location");

    public final NumberPath<Long> maintenanceFee = createNumber("maintenanceFee", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyTs = _super.modifyTs;

    public final NumberPath<Long> monthlyPayment = createNumber("monthlyPayment", Long.class);

    public final NumberPath<Integer> numOfBathrooms = createNumber("numOfBathrooms", Integer.class);

    public final NumberPath<Integer> numOfRooms = createNumber("numOfRooms", Integer.class);

    public final NumberPath<Integer> parkingSpaces = createNumber("parkingSpaces", Integer.class);

    public final QPropertyType propertyType;

    public final NumberPath<Integer> totalFloors = createNumber("totalFloors", Integer.class);

    public final QTransactionType transactionType;

    public QProperty(String variable) {
        this(Property.class, forVariable(variable), INITS);
    }

    public QProperty(Path<? extends Property> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProperty(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProperty(PathMetadata metadata, PathInits inits) {
        this(Property.class, metadata, inits);
    }

    public QProperty(Class<? extends Property> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.agencyInfo = inits.isInitialized("agencyInfo") ? new QRealEstateAgencyInfo(forProperty("agencyInfo")) : null;
        this.propertyType = inits.isInitialized("propertyType") ? new QPropertyType(forProperty("propertyType")) : null;
        this.transactionType = inits.isInitialized("transactionType") ? new QTransactionType(forProperty("transactionType")) : null;
    }

}

