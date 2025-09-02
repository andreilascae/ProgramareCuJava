package AWBD.HealthSched.DTO;

import java.time.LocalDateTime;

public class ProgramareDTO {
    private Long id;
    private Long pacientId;
    private Long doctorId;
    private LocalDateTime dataOra;
    private String motiv;
    private String status; // CREATED / CONFIRMED / CANCELLED

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPacientId() { return pacientId; }
    public void setPacientId(Long pacientId) { this.pacientId = pacientId; }

    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public LocalDateTime getDataOra() { return dataOra; }
    public void setDataOra(LocalDateTime dataOra) { this.dataOra = dataOra; }

    public String getMotiv() { return motiv; }
    public void setMotiv(String motiv) { this.motiv = motiv; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
