package AWBD.HealthSched.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String adresa;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Doctor> doctori = new HashSet<>();

    //  Constructori
    public Clinica() {}

    public Clinica(String nume, String adresa) {
        this.nume = nume;
        this.adresa = adresa;
    }

    //  Getteri și setteri
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }

    public Set<Doctor> getDoctori() { return doctori; }
    public void setDoctori(Set<Doctor> doctori) { this.doctori = doctori; }
}
