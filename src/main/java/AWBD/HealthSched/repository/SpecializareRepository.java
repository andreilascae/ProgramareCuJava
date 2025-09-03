package AWBD.HealthSched.repository;

import AWBD.HealthSched.model.Specializare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecializareRepository extends JpaRepository<Specializare, Long> {
    Optional<Specializare> findByNume(String nume);
}
