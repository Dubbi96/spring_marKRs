package pe.veriestate.asan.auth.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.veriestate.asan.auth.domain.entity.VeriEstateUser;

import java.util.Optional;

public interface VeriEstateUserRepository extends JpaRepository<VeriEstateUser, Long> {
    Optional<VeriEstateUser> findByEmailAndProvider(String email, String provider);
}
