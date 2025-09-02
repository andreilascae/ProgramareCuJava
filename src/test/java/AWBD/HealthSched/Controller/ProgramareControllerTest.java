package AWBD.HealthSched.Controller;

import AWBD.HealthSched.DTO.ProgramareCreateDTO;
import AWBD.HealthSched.DTO.ProgramareDTO;
import AWBD.HealthSched.Service.ProgramareService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProgramareController.class)
class ProgramareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProgramareService programareService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void create_returns201() throws Exception {
        ProgramareCreateDTO dto = new ProgramareCreateDTO();
        dto.setPacientId(1L);
        dto.setDoctorId(2L);
        dto.setDataOra(LocalDateTime.now().plusDays(1));
        dto.setMotiv("Control");

        ProgramareDTO out = new ProgramareDTO();
        out.setId(10L);
        Mockito.when(programareService.create(Mockito.any())).thenReturn(out);

        mockMvc.perform(post("/api/programari")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }
}
