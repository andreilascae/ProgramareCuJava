package AWBD.HealthSched.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // va încărca login.html din templates
    }

    @GetMapping("/logout-success")
    public String logout() {
        return "redirect:/login?logout";
    }
}
