package br.com.asaplog.veiculoseguro.test.resources;

import br.com.asaplog.veiculoseguro.models.dto.ApoliceDTO;
import br.com.asaplog.veiculoseguro.models.embedded.ClienteSummary;
import br.com.asaplog.veiculoseguro.repositories.ClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataMongo
public class ApoliceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ObjectMapper mapper;

    JacksonJsonParser jsonParser = new JacksonJsonParser();

    @Test
    void save_shouldReturnApoliceDTO_whenValidInput() throws Exception {
        ClienteSummary cliente = new ClienteSummary(null, "John Wood", "77351438005");
        ApoliceDTO apolice = new ApoliceDTO(null,
                null,
                Instant.parse("2020-04-01T14:00:00Z"),
                Instant.parse("2021-04-01T14:00:00Z"),
                "AAA-1122",
                new BigDecimal(2500),
                cliente);
        String jsonBody = mapper.writeValueAsString(apolice);

        ResultActions result = mockMvc.perform(post("/apolices")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody));

        result.andExpect(status().isCreated());
        result.andExpect(jsonPath("$.codigo").isNotEmpty());
    }

    @Test
    void save_shouldReturnValidationException_whenInvalidInput() throws Exception {
        ClienteSummary cliente = new ClienteSummary(null, "John Wood", "77351438005");
        ApoliceDTO apolice = new ApoliceDTO(null,
                null,
                Instant.parse("2020-04-01T14:00:00Z"),
                null,
                "AAA-1122",
                new BigDecimal(-100),
                cliente);
        String jsonBody = mapper.writeValueAsString(apolice);

        ResultActions result = mockMvc.perform(post("/apolices")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody));

        result.andExpect(status().isUnprocessableEntity());
        result.andExpect(jsonPath("$.error").value("Validation exception"));
    }
}
