package AWBD.HealthSched.Controller;

import AWBD.HealthSched.model.Specializare;
import AWBD.HealthSched.repository.SpecializareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specializari")
public class SpecializareController {

    @Autowired
    private SpecializareRepository repo;

    @GetMapping
    public List<Specializare> getAll() { return repo.findAll(); }

    @PostMapping
    public Specializare create(@RequestBody Specializare s) { return repo.save(s); }
}

