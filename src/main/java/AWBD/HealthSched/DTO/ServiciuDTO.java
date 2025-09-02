package AWBD.HealthSched.DTO;

import java.util.List;

public class ServiciuDTO {
    private Long id;
    private String nume;
    private String descriere;
    private Double pret;
    private List<DoctorDTO> doctori;

    public ServiciuDTO(Long id, String nume, String descriere, Double pret, List<DoctorDTO> doctori) {
        this.id = id;
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
        this.doctori = doctori;
    }

    // Getteri și setteri
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    public Double getPret() { return pret; }
    public void setPret(Double pret) { this.pret = pret; }

    public List<DoctorDTO> getDoctori() { return doctori; }
    public void setDoctori(List<DoctorDTO> doctori) { this.doctori = doctori; }
}
