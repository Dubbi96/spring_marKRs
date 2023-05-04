package pe.marker.asan.auth.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.marker.asan.auth.domain.entity.MarkrsUser;

import java.util.Optional;

public interface MarkrsUserRepository extends JpaRepository<MarkrsUser, Long> {
    Optional<MarkrsUser> findByEmailAndProvider(String email, String provider);
}
