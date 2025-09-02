package AWBD.HealthSched.mapper;

import AWBD.HealthSched.DTO.ProgramareDTO;
import AWBD.HealthSched.model.Programare;

public class ProgramareMapper {
    public static ProgramareDTO toDto(Programare p) {
        ProgramareDTO dto = new ProgramareDTO();
        dto.setId(p.getId());
        if (p.getPacient() != null) dto.setPacientId(p.getPacient().getId());
        if (p.getDoctor() != null) dto.setDoctorId(p.getDoctor().getId());
        dto.setDataOra(p.getDataOra());
        dto.setMotiv(p.getMotiv());
        dto.setStatus(p.getStatus() == null ? null : p.getStatus().name());
        return dto;
    }
}
