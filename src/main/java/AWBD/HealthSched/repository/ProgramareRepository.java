package AWBD.HealthSched.repository;

import AWBD.HealthSched.model.Programare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProgramareRepository extends JpaRepository<Programare, Long> {

    boolean existsByDoctor_IdAndDataOra(Long doctorId, LocalDateTime dataOra);

    List<Programare> findByDoctor_Id(Long doctorId);

    List<Programare> findByPacient_Id(Long pacientId);
}
