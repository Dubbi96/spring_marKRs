package pe.veriestate.asan.property.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import pe.veriestate.asan.common.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@SuperBuilder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "REAL_ESTATE_AGENCY_INFO")
public class RealEstateAgencyInfo extends BaseEntity {

    @Column(name = "AGENCY_NAME")
    private String agencyName;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @Column(name = "AGENT_NAME")
    private String agentName;
}
