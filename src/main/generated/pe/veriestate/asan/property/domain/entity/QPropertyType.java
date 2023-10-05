package pe.veriestate.asan.property.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPropertyType is a Querydsl query type for PropertyType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPropertyType extends EntityPathBase<PropertyType> {

    private static final long serialVersionUID = -949328643L;

    public static final QPropertyType propertyType1 = new QPropertyType("propertyType1");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath propertyType = createString("propertyType");

    public QPropertyType(String variable) {
        super(PropertyType.class, forVariable(variable));
    }

    public QPropertyType(Path<? extends PropertyType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPropertyType(PathMetadata metadata) {
        super(PropertyType.class, metadata);
    }

}

