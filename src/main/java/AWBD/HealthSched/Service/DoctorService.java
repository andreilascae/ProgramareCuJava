package AWBD.HealthSched.Service;

import AWBD.HealthSched.DTO.DoctorDTO;
import AWBD.HealthSched.model.Doctor;
import AWBD.HealthSched.repository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public Page<DoctorDTO> getDoctorsPaginated(Pageable pageable) {
        return doctorRepository.findAll(pageable)
                .map(this::mapToDTO);
    }
    private DoctorDTO mapToDTO(Doctor doctor) {
        return new DoctorDTO(
                doctor.getId(),
                doctor.getNume(),
                doctor.getPrenume(),
                doctor.getEmail(),
                doctor.getTelefon(),
                doctor.getSpecializare()
        );
    }

    private Doctor mapToEntity(DoctorDTO dto) {
        return new Doctor(dto.getId(), dto.getNume(), dto.getPrenume(),
                dto.getEmail(), dto.getTelefon(), dto.getSpecializare());
    }

    public List<DoctorDTO> getAllDoctors() {
        logger.info("Preluare listă doctori din baza de date");
        return doctorRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void saveDoctor(DoctorDTO dto) {
        Doctor doctor = mapToEntity(dto);
        logger.info("Salvare doctor: {} {}", doctor.getNume(), doctor.getPrenume());
        doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        logger.info("Căutare doctor cu ID: {}", id);
        return doctorRepository.findById(id).orElse(null);
    }

    public void deleteDoctor(Long id) {
        logger.warn("Ștergere doctor cu ID: {}", id);
        doctorRepository.deleteById(id);
    }
}
