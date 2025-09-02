package AWBD.HealthSched.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Specializare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;

    @OneToMany(mappedBy = "specializare")
    private List<Doctor> doctori = new ArrayList<>();

    public Specializare() {}
    public Specializare(String nume) { this.nume = nume; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public List<Doctor> getDoctori() { return doctori; }
    public void setDoctori(List<Doctor> doctori) { this.doctori = doctori; }
}