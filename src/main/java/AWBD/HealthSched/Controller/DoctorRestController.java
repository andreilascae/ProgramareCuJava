package AWBD.HealthSched.Controller;

import AWBD.HealthSched.DTO.DoctorDTO;
import AWBD.HealthSched.model.Doctor;
import AWBD.HealthSched.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/api/doctors", "/api/doctori"})
@Validated
public class DoctorRestController {

    @Autowired
    private DoctorRepository doctorRepository;

    // ---------- DTO mapping (String <-> String) ----------
    private DoctorDTO toDto(Doctor d) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(d.getId());
        dto.setNume(d.getNume());
        dto.setPrenume(d.getPrenume());
        dto.setEmail(d.getEmail());
        dto.setTelefon(d.getTelefon());
        // entitatea Doctor are specializare de tip String
        dto.setSpecializare(d.getSpecializare());
        return dto;
    }

    private Doctor fromDto(DoctorDTO dto) {
        Doctor d = new Doctor();
        d.setId(dto.getId());
        d.setNume(dto.getNume());
        d.setPrenume(dto.getPrenume());
        d.setEmail(dto.getEmail());
        d.setTelefon(dto.getTelefon());
        // conversie directă String -> String
        d.setSpecializare(dto.getSpecializare());
        return d;
    }
    // -----------------------------------------------------

    @GetMapping
    public List<DoctorDTO> all() {
        return doctorRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> create(@RequestBody @Valid DoctorDTO dto) {
        Doctor saved = doctorRepository.save(fromDto(dto));
        return ResponseEntity
                .created(URI.create("/api/doctors/" + saved.getId()))
                .body(toDto(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> byId(@PathVariable Long id) {
        return doctorRepository.findById(id)
                .map(d -> ResponseEntity.ok(toDto(d)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!doctorRepository.existsById(id)) return ResponseEntity.notFound().build();
        doctorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
