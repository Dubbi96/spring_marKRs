package pe.veriestate.asan.property.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTransactionType is a Querydsl query type for TransactionType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransactionType extends EntityPathBase<TransactionType> {

    private static final long serialVersionUID = -729909718L;

    public static final QTransactionType transactionType1 = new QTransactionType("transactionType1");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath transactionType = createString("transactionType");

    public QTransactionType(String variable) {
        super(TransactionType.class, forVariable(variable));
    }

    public QTransactionType(Path<? extends TransactionType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTransactionType(PathMetadata metadata) {
        super(TransactionType.class, metadata);
    }

}

