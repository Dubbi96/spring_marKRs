package pe.veriestate.asan.code.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.veriestate.asan.code.domain.entity.CodeJpaEntity;

public interface CodeJpaRepository extends JpaRepository<CodeJpaEntity, Long> {
}
