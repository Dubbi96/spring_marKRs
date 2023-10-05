package pe.veriestate.asan.property.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import pe.veriestate.asan.common.domain.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@SuperBuilder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Property extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private RealEstateAgencyInfo agencyInfo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private PropertyType propertyType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private TransactionType transactionType;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "AREA_SQM")
    private Long areaSqm;

    @Column(name = "DEPOSITE_AMOUNT")
    private Long depositeAmount;

    @Column(name = "MONTHLY_PAYMENT")
    private Long monthlyPayment;

    @Column(name = "TOTAL_FLOORS")
    private Integer totalFloors;

    @Column(name = "AVAILABLE_DATE")
    private LocalDate availableDate;

    @Column(name = "NUM_ROOMS")
    private Integer numOfRooms;

    @Column(name = "NUM_BATHROOMS")
    private Integer numOfBathrooms;

    @Column(name = "APPROVAL_DATE")
    private LocalDate approvalDate;

    @Column(name = "PARKING_SPACES")
    private Integer parkingSpaces;

    @Column(name = "MAINTENANCE_FEE")
    private Long maintenanceFee;

    @Column(name = "DIRECTION")
    private String direction;
    }
