package AWBD.HealthSched.model;

import AWBD.HealthSched.model.enums.ProgramareStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Programare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataOra;

    private String motiv;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    private ProgramareStatus status;

    public Programare() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataOra() { return dataOra; }
    public void setDataOra(LocalDateTime dataOra) { this.dataOra = dataOra; }

    public String getMotiv() { return motiv; }
    public void setMotiv(String motiv) { this.motiv = motiv; }

    public Pacient getPacient() { return pacient; }
    public void setPacient(Pacient pacient) { this.pacient = pacient; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public ProgramareStatus getStatus() { return status; }
    public void setStatus(ProgramareStatus status) { this.status = status; }
}
