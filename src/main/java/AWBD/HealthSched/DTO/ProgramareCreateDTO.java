package AWBD.HealthSched.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ProgramareCreateDTO {

    @NotNull
    private Long pacientId;

    @NotNull
    private Long doctorId;

    @Future
    @NotNull
    private LocalDateTime dataOra;

    @NotBlank
    private String motiv;

    public Long getPacientId() { return pacientId; }
    public void setPacientId(Long pacientId) { this.pacientId = pacientId; }

    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public LocalDateTime getDataOra() { return dataOra; }
    public void setDataOra(LocalDateTime dataOra) { this.dataOra = dataOra; }

    public String getMotiv() { return motiv; }
    public void setMotiv(String motiv) { this.motiv = motiv; }
}
