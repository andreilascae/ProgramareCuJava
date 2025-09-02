package AWBD.HealthSched.Controller;

import AWBD.HealthSched.DTO.DoctorDTO;
import AWBD.HealthSched.Service.DoctorService;
import AWBD.HealthSched.model.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Controller
@RequestMapping("/doctori")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public String listDoctors(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "nume") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<DoctorDTO> doctorPage = doctorService.getDoctorsPaginated(pageable);

        model.addAttribute("doctorPage", doctorPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("sortBy", sortBy);

        return "doctor/list";
    }
    // @Valid + BindingResults - formularul este reincarcat si se pot afisa mesaje
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/add"; // Vei crea doctor/add.html
    }

    @PostMapping
    public String saveDoctor(
            @ModelAttribute("doctor") @Valid DoctorDTO doctorDTO,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("doctor", doctorDTO);
            return "doctor/add";
        }

        doctorService.saveDoctor(doctorDTO);
        return "redirect:/doctori";
    }



    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctori";
    }
}
