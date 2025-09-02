package AWBD.HealthSched.Service;

import AWBD.HealthSched.DTO.ProgramareCreateDTO;
import AWBD.HealthSched.DTO.ProgramareDTO;
import AWBD.HealthSched.exception.ConflictException;
import AWBD.HealthSched.exception.ResourceNotFoundException;
import AWBD.HealthSched.mapper.ProgramareMapper;
import AWBD.HealthSched.model.Doctor;
import AWBD.HealthSched.model.Pacient;
import AWBD.HealthSched.model.Programare;
import AWBD.HealthSched.model.enums.ProgramareStatus;
import AWBD.HealthSched.repository.DoctorRepository;
import AWBD.HealthSched.repository.PacientRepository;
import AWBD.HealthSched.repository.ProgramareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgramareService {

    @Autowired
    private ProgramareRepository programareRepository;
    @Autowired
    private PacientRepository pacientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    // ------- folosite de MVC existent -------
    public List<Programare> getAllProgramari() {
        return programareRepository.findAll();
    }

    public Optional<Programare> getProgramareById(Long id) {
        return programareRepository.findById(id);
    }

    public Programare saveProgramare(Programare programare) {
        if (programare.getStatus() == null) programare.setStatus(ProgramareStatus.CREATED);
        return programareRepository.save(programare);
    }

    public void deleteProgramare(Long id) {
        programareRepository.deleteById(id);
    }
    // ----------------------------------------

    // ------- REST nou cu validări business -------
    @Transactional
    public ProgramareDTO create(ProgramareCreateDTO dto) {
        Pacient pacient = pacientRepository.findById(dto.getPacientId())
                .orElseThrow(() -> new ResourceNotFoundException("Pacient inexistent"));
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor inexistent"));

        if (dto.getDataOra().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Programare în trecut");
        }

        if (programareRepository.existsByDoctor_IdAndDataOra(doctor.getId(), dto.getDataOra())) {
            throw new ConflictException("Există deja o programare la aceeași oră pentru acest medic");
        }

        Programare p = new Programare();
        p.setPacient(pacient);
        p.setDoctor(doctor);
        p.setDataOra(dto.getDataOra());
        p.setMotiv(dto.getMotiv());
        p.setStatus(ProgramareStatus.CREATED);

        return ProgramareMapper.toDto(programareRepository.save(p));
    }

    @Transactional
    public void cancel(Long id) {
        Programare p = programareRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Programare inexistentă"));
        p.setStatus(ProgramareStatus.CANCELLED);
    }

    public List<ProgramareDTO> list(Long doctorId, Long pacientId) {
        List<Programare> base;
        if (doctorId != null) {
            base = programareRepository.findByDoctor_Id(doctorId);
        } else if (pacientId != null) {
            base = programareRepository.findByPacient_Id(pacientId);
        } else {
            base = programareRepository.findAll();
        }
        return base.stream().map(ProgramareMapper::toDto).collect(Collectors.toList());
    }
}
