package AWBD.HealthSched.repository;

import AWBD.HealthSched.model.Plata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlataRepository extends JpaRepository<Plata, Long> {
    boolean existsByProgramare_Id(Long programareId);
}
