package AWBD.HealthSched.Controller;

import AWBD.HealthSched.model.Serviciu;
import AWBD.HealthSched.model.Doctor;
import AWBD.HealthSched.repository.ServiciuRepository;
import AWBD.HealthSched.repository.DoctorRepository;
import AWBD.HealthSched.DTO.ServiciuDTO;
import AWBD.HealthSched.DTO.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/servicii")
public class ServiciuController {

    @Autowired
    private ServiciuRepository serviciuRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping
    public List<ServiciuDTO> getAllServicii() {
        List<Serviciu> servicii = serviciuRepository.findAll();
        return servicii.stream().map(serviciu -> {
            List<DoctorDTO> doctori = serviciu.getDoctori().stream()
                    .map(doc -> new DoctorDTO(
                            doc.getId(),
                            doc.getNume(),
                            doc.getPrenume(),
                            doc.getEmail(),
                            doc.getTelefon(),
                            doc.getSpecializare()
                    ))
                    .collect(Collectors.toList());

            return new ServiciuDTO(
                    serviciu.getId(),
                    serviciu.getNume(),
                    serviciu.getDescriere(),
                    serviciu.getPret(),
                    doctori
            );
        }).collect(Collectors.toList());
    }


    @PostMapping
    public Serviciu createServiciu(@RequestBody Serviciu serviciu) {
        return serviciuRepository.save(serviciu);
    }


    @PostMapping("/{serviciuId}/doctori")
    public Serviciu adaugaDoctorLaServiciu(@PathVariable Long serviciuId, @RequestParam Long doctorId) {
        Serviciu serviciu = serviciuRepository.findById(serviciuId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        serviciu.getDoctori().add(doctor);
        doctor.getServicii().add(serviciu);

        doctorRepository.save(doctor);
        return serviciuRepository.save(serviciu);
    }
}
