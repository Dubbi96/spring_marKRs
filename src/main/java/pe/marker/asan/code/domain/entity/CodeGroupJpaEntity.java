package pe.marker.asan.code.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "TEST_CODE_GROUP")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CodeGroupJpaEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "DISPLAY_ID")
    @NotBlank
    private String displayId;

    @Column(name = "NAME")
    @NotBlank
    private String name;

    @Column(name = "DESCRIPTION")
    @NotNull
    private String description;

    @Column(name = "DELETED", nullable = true)
    private LocalDateTime deleted;

    static public CodeGroupJpaEntity of(String displayId, String name, String description) {
        CodeGroupJpaEntity entity = new CodeGroupJpaEntity();
        entity.id = null;
        entity.displayId = displayId;
        entity.name = name;
        entity.description = description;
        entity.deleted = null;

        return entity;
    }
}
