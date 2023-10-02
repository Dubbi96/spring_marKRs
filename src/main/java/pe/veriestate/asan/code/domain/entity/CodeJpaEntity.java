package pe.veriestate.asan.code.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "TEST_CODE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CodeJpaEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name = "GROUP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private CodeGroupJpaEntity codeGroup;

    @Column(name = "POSITION")
    @NotNull
    private Integer position;

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

    static public CodeJpaEntity of(CodeGroupJpaEntity codeGroup, Integer position, String displayId, String name, String description) {
        CodeJpaEntity entity = new CodeJpaEntity();
        entity.id = null;
        entity.codeGroup = codeGroup;
        entity.position = position;
        entity.displayId = displayId;
        entity.name = name;
        entity.description = description;
        entity.deleted = null;

        return entity;
    }
}
