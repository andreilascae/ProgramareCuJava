package AWBD.HealthSched.Controller;

import AWBD.HealthSched.Service.PlataService;
import AWBD.HealthSched.model.Plata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plati")
public class PlataController {

    @Autowired
    private PlataService plataService;

    @PostMapping
    public ResponseEntity<Plata> create(@RequestParam Long programareId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(plataService.createForProgramare(programareId));
    }
}
