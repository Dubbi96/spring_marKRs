package pe.veriestate.asan.common.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
public class HisId implements Serializable {
    @Column(name = "ID")
    private Long id;

    @Column(name = "VERSION")
    private Long version;

    private HisId(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public static HisId of(Long id, Long version) {
        return new HisId(id, version);
    }
}
