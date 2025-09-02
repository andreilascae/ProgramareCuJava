package AWBD.HealthSched.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String prenume;
    private String email;
    private String telefon;
    private String specializare;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;

    @ManyToMany
    @JoinTable(
            name = "doctor_serviciu",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "serviciu_id")
    )
    private Set<Serviciu> servicii = new HashSet<>();

    @OneToOne(mappedBy = "doctor")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //  Constructori
    public Doctor() {}

    public Doctor(Long id, String nume, String prenume, String email, String telefon, String specializare) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.specializare = specializare;
    }


    // Getteri & Setteri
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getPrenume() { return prenume; }
    public void setPrenume(String prenume) { this.prenume = prenume; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getSpecializare() { return specializare; }
    public void setSpecializare(String specializare) { this.specializare = specializare; }

    public Clinica getClinica() { return clinica; }
    public void setClinica(Clinica clinica) { this.clinica = clinica; }

    public Set<Serviciu> getServicii() { return servicii; }
    public void setServicii(Set<Serviciu> servicii) { this.servicii = servicii; }
}
