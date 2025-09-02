package AWBD.HealthSched.Service;

import AWBD.HealthSched.exception.ConflictException;
import AWBD.HealthSched.exception.ResourceNotFoundException;
import AWBD.HealthSched.model.Plata;
import AWBD.HealthSched.model.Programare;
import AWBD.HealthSched.model.enums.ProgramareStatus;
import AWBD.HealthSched.repository.PlataRepository;
import AWBD.HealthSched.repository.ProgramareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlataService {

    @Autowired
    private ProgramareRepository programareRepository;

    @Autowired
    private PlataRepository plataRepository;

    @Transactional
    public Plata createForProgramare(Long programareId) {
        Programare p = programareRepository.findById(programareId)
                .orElseThrow(() -> new ResourceNotFoundException("Programare inexistentă"));

        if (p.getStatus() == ProgramareStatus.CANCELLED) {
            throw new ConflictException("Nu poți plăti o programare anulată");
        }
        if (plataRepository.existsByProgramare_Id(programareId)) {
            throw new ConflictException("Există deja o plată pentru această programare");
        }

        Plata plata = new Plata();
        plata.setProgramare(p);
        return plataRepository.save(plata);
    }
}
