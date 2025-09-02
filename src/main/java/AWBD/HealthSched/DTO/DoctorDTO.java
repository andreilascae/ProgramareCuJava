package AWBD.HealthSched.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DoctorDTO {
    private Long id;

    @NotBlank(message = "Numele este obligatoriu.")
    @Size(min = 2, max = 50, message = "Numele trebuie să aibă între 2 și 50 de caractere.")
    private String nume;

    @NotBlank(message = "Prenumele este obligatoriu.")
    private String prenume;

    @Email(message = "Email invalid.")
    @NotBlank(message = "Emailul este obligatoriu.")
    private String email;

    @NotBlank(message = "Telefonul este obligatoriu.")
    private String telefon;

    @NotBlank(message = "Specializarea este obligatorie.")
    private String specializare;

    public DoctorDTO() {}

    public DoctorDTO(Long id, String nume, String prenume, String email, String telefon, String specializare) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.specializare = specializare;
    }

    // Getteri și setteri
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
}
