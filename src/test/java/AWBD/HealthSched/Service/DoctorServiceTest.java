/*package AWBD.HealthSched.service;

import AWBD.HealthSched.model.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")  // rulăm cu H2 in-memory
public class DoctorServiceTest {

    @Autowired
    private DoctorService doctorService;

    @Test
    void testSaveAndFetchDoctor() {
        // Cream un doctor real
        Doctor doctor = new Doctor(
                "Test", "Doctor", "test@med.com", "0700000000", "Dermatologie"
        );

        doctorService.saveDoctor(doctor); // METODĂ din DoctorService care primește Doctor

        assertEquals(1, doctorService.getAllDoctors().size());
    }
}
