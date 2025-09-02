package AWBD.HealthSched.Controller;

import AWBD.HealthSched.model.User;
import AWBD.HealthSched.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping
    public List<User> getAll() { return repo.findAll(); }

    @PostMapping
    public User create(@RequestBody User user) {
        return repo.save(user);
    }
}
