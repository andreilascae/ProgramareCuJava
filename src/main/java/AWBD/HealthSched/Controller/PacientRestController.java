package AWBD.HealthSched.Controller;

import AWBD.HealthSched.DTO.PacientDTO;
import AWBD.HealthSched.model.Pacient;
import AWBD.HealthSched.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pacienti")
public class PacientRestController {

    @Autowired
    private PacientRepository pacientRepository;

    private PacientDTO toDto(Pacient p){
        PacientDTO dto = new PacientDTO();
        dto.setId(p.getId());
        dto.setNume(p.getNume());
        dto.setPrenume(p.getPrenume());
        dto.setEmail(p.getEmail());
        dto.setTelefon(p.getTelefon());
        dto.setCnp(p.getCnp());
        return dto;
    }

    private Pacient fromDto(PacientDTO dto){
        Pacient p = new Pacient();
        p.setId(dto.getId());
        p.setNume(dto.getNume());
        p.setPrenume(dto.getPrenume());
        p.setEmail(dto.getEmail());
        p.setTelefon(dto.getTelefon());
        p.setCnp(dto.getCnp());
        return p;
    }

    @GetMapping
    public List<PacientDTO> all(){
        return pacientRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PacientDTO> create(@RequestBody PacientDTO dto){
        Pacient saved = pacientRepository.save(fromDto(dto));
        return ResponseEntity.created(URI.create("/api/pacienti/" + saved.getId())).body(toDto(saved));
    }
}
