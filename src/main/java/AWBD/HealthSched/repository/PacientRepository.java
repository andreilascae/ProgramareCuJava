package AWBD.HealthSched.repository;

import AWBD.HealthSched.model.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository<Pacient, Long> {
    // putem adăuga metode custom mai târziu
}
