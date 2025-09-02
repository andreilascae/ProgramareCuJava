package AWBD.HealthSched.Controller;

import AWBD.HealthSched.Service.DoctorService;
import AWBD.HealthSched.Service.PacientService;
import AWBD.HealthSched.Service.ProgramareService;
import AWBD.HealthSched.model.Programare;
import AWBD.HealthSched.model.Doctor;
import AWBD.HealthSched.model.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/programari")
public class ProgramareMvcController {

    private final ProgramareService programareService;
    private final DoctorService doctorService;
    private final PacientService pacientService;

    @Autowired
    public ProgramareMvcController(ProgramareService programareService,
                                   DoctorService doctorService,
                                   PacientService pacientService) {
        this.programareService = programareService;
        this.doctorService = doctorService;
        this.pacientService = pacientService;
    }

    @GetMapping
    public String listProgramari(Model model) {
        List<Programare> programari = programareService.getAllProgramari();
        model.addAttribute("programari", programari);
        return "programare/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("programare", new Programare());
        model.addAttribute("doctori", doctorService.getAllDoctors());
        model.addAttribute("pacienti", pacientService.getAllPacienti());
        return "programare/add";
    }

    @PostMapping
    public String saveProgramare(@ModelAttribute Programare programare) {
        programareService.saveProgramare(programare);
        return "redirect:/programari";
    }

    @GetMapping("/delete/{id}")
    public String deleteProgramare(@PathVariable Long id) {
        programareService.deleteProgramare(id);
        return "redirect:/programari";
    }
}
