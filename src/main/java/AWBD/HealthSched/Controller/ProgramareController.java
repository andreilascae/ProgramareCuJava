package AWBD.HealthSched.Controller;

import AWBD.HealthSched.DTO.ProgramareCreateDTO;
import AWBD.HealthSched.DTO.ProgramareDTO;
import AWBD.HealthSched.Service.ProgramareService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programari")
public class ProgramareController {

    @Autowired
    private ProgramareService programareService;

    @GetMapping
    public List<ProgramareDTO> list(
            @RequestParam(required = false) Long doctorId,
            @RequestParam(required = false) Long pacientId
    ) {
        return programareService.list(doctorId, pacientId);
    }

    @PostMapping
    public ResponseEntity<ProgramareDTO> create(@RequestBody @Valid ProgramareCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(programareService.create(dto));
    }

    @PatchMapping("/{id}/anuleaza")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        programareService.cancel(id);
        return ResponseEntity.noContent().build();
    }
}
