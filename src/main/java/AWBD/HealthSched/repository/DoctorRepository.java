package AWBD.HealthSched.repository;

import AWBD.HealthSched.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
