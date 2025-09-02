package AWBD.HealthSched.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Serviciu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String descriere;
    private Double pret;

    @ManyToMany(mappedBy = "servicii")
    private Set<Doctor> doctori = new HashSet<>();

    // Getteri și setteri
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    public Double getPret() { return pret; }
    public void setPret(Double pret) { this.pret = pret; }

    public Set<Doctor> getDoctori() { return doctori; }
    public void setDoctori(Set<Doctor> doctori) { this.doctori = doctori; }
}
