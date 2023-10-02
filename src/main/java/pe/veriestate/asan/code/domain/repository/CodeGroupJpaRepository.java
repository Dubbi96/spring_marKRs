package pe.veriestate.asan.code.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.veriestate.asan.code.domain.entity.CodeGroupJpaEntity;

public interface CodeGroupJpaRepository extends JpaRepository<CodeGroupJpaEntity, Long> {
}
