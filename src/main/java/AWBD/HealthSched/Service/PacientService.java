package AWBD.HealthSched.Service;

import AWBD.HealthSched.model.Pacient;
import AWBD.HealthSched.repository.PacientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientService {

    private final PacientRepository pacientRepository;

    public PacientService(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    public List<Pacient> getAllPacienti() {
        return pacientRepository.findAll();
    }

    public void savePacient(Pacient pacient) {
        pacientRepository.save(pacient);
    }

    public void deletePacient(Long id) {
        pacientRepository.deleteById(id);
    }


}
