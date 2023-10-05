package pe.veriestate.asan.property.domain.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@SuperBuilder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class TransactionType {
    @Id
    private Long id;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;
}
