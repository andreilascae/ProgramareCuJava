package AWBD.HealthSched.Service;

import AWBD.HealthSched.DTO.ProgramareCreateDTO;
import AWBD.HealthSched.exception.ConflictException;
import AWBD.HealthSched.exception.ResourceNotFoundException;
import AWBD.HealthSched.model.Doctor;
import AWBD.HealthSched.model.Pacient;
import AWBD.HealthSched.repository.DoctorRepository;
import AWBD.HealthSched.repository.PacientRepository;
import AWBD.HealthSched.repository.ProgramareRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProgramareServiceTest {

    private ProgramareRepository programareRepository;
    private PacientRepository pacientRepository;
    private DoctorRepository doctorRepository;
    private ProgramareService service;

    @BeforeEach
    void setUp() {
        programareRepository = mock(ProgramareRepository.class);
        pacientRepository = mock(PacientRepository.class);
        doctorRepository = mock(DoctorRepository.class);
        service = new ProgramareService();
        // inject by reflection (simplu)
        try {
            var f1 = ProgramareService.class.getDeclaredField("programareRepository");
            f1.setAccessible(true); f1.set(service, programareRepository);
            var f2 = ProgramareService.class.getDeclaredField("pacientRepository");
            f2.setAccessible(true); f2.set(service, pacientRepository);
            var f3 = ProgramareService.class.getDeclaredField("doctorRepository");
            f3.setAccessible(true); f3.set(service, doctorRepository);
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    @Test
    void create_ok() {
        var nowPlus = LocalDateTime.now().plusDays(1);
        var dto = new ProgramareCreateDTO();
        dto.setPacientId(1L); dto.setDoctorId(2L); dto.setDataOra(nowPlus); dto.setMotiv("Control");

        when(pacientRepository.findById(1L)).thenReturn(Optional.of(new Pacient()));
        when(doctorRepository.findById(2L)).thenReturn(Optional.of(new Doctor()));
        when(programareRepository.existsByDoctor_IdAndDataOra(2L, nowPlus)).thenReturn(false);
        when(programareRepository.save(ArgumentMatchers.any())).thenAnswer(a -> a.getArgument(0));

        var result = service.create(dto);
        assertNotNull(result);
        assertEquals("Control", result.getMotiv());
    }

    @Test
    void create_throws_when_pacient_missing() {
        var dto = new ProgramareCreateDTO();
        dto.setPacientId(1L); dto.setDoctorId(2L); dto.setDataOra(LocalDateTime.now().plusDays(1)); dto.setMotiv("x");
        when(pacientRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.create(dto));
    }

    @Test
    void create_throws_when_overlap() {
        var nowPlus = LocalDateTime.now().plusDays(1);
        var dto = new ProgramareCreateDTO();
        dto.setPacientId(1L); dto.setDoctorId(2L); dto.setDataOra(nowPlus); dto.setMotiv("x");

        when(pacientRepository.findById(1L)).thenReturn(Optional.of(new Pacient()));
        when(doctorRepository.findById(2L)).thenReturn(Optional.of(new Doctor()));
        when(programareRepository.existsByDoctor_IdAndDataOra(2L, nowPlus)).thenReturn(true);

        assertThrows(ConflictException.class, () -> service.create(dto));
    }
}
