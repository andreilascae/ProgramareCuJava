package AWBD.HealthSched.Controller;

import AWBD.HealthSched.model.Clinica;
import AWBD.HealthSched.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinici")
public class ClinicaController {

    @Autowired
    private ClinicaRepository repo;

    @GetMapping
    public List<Clinica> getAll() { return repo.findAll(); }

    @PostMapping
    public Clinica create(@RequestBody Clinica c) { return repo.save(c); }
}
