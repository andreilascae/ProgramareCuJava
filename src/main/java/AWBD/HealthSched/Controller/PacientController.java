package AWBD.HealthSched.Controller;

import AWBD.HealthSched.Service.PacientService;
import AWBD.HealthSched.model.Pacient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pacienti")
public class PacientController {

    private final PacientService pacientService;

    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @GetMapping
    public String listPacienti(Model model) {
        List<Pacient> pacienti = pacientService.getAllPacienti();
        model.addAttribute("pacienti", pacienti);
        return "pacient/list"; // creezi pacient/list.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("pacient", new Pacient());
        return "pacient/add"; // creezi pacient/add.html
    }

    @PostMapping
    public String savePacient(@ModelAttribute Pacient pacient) {
        pacientService.savePacient(pacient);
        return "redirect:/pacienti";
    }

    @GetMapping("/delete/{id}")
    public String deletePacient(@PathVariable Long id) {
        pacientService.deletePacient(id);
        return "redirect:/pacienti";
    }
}
