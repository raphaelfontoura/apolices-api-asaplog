package br.com.asaplog.veiculoseguro.test.resources;

import br.com.asaplog.veiculoseguro.models.dto.ClienteDTO;
import br.com.asaplog.veiculoseguro.repositories.ClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataMongo
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ObjectMapper mapper;

    JacksonJsonParser jsonParser = new JacksonJsonParser();
    String notExistId;

    @BeforeEach
    void setUp() {
        notExistId = "a12s43df4";
    }

    @Test
    void findAll_shouldReturnAllClients() throws Exception {
        ResultActions result = mockMvc.perform(get("/clientes").contentType(MediaType.APPLICATION_JSON));
        String resultString = result.andReturn().getResponse().getContentAsString();
        ClienteDTO[] clientes = getClientes(result);
        
        result.andExpect(status().isOk());
        result.andExpect(r -> r.getResponse().getContentAsString().contains("Raphael Fontoura"));
        Assertions.assertTrue(resultString.contains("Gladson Fontoura"));
        Assertions.assertEquals(2, clientes.length);
    }

    @Test
    void findById_shouldReturnNotFoundException_whenIdNotExists() throws Exception {
        ResultActions result = mockMvc.perform(get("/clientes/{id}", notExistId).contentType(MediaType.APPLICATION_JSON));
        result.andExpect(status().is(404));
        result.andExpect(jsonPath("$.error").exists());
        result.andExpect(jsonPath("$.error").value("Not found"));
    }

    @Test
    void save_shouldReturnClienteDTO_whenValidInput() throws Exception {
        ClienteDTO validInput = new ClienteDTO(null, "Dayse Galisa", "63276402068", "Brasília", "DF");
        String jsonBody = mapper.writeValueAsString(validInput);

        ResultActions result = mockMvc.perform(post("/clientes")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated());
        result.andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    void save_shouldReturnValidationException_whenInvalidCPFInput() throws Exception {
        ClienteDTO validInput = new ClienteDTO(null, "Dayse Galisa", "11122233344", "Brasília", "DF");
        String jsonBody = mapper.writeValueAsString(validInput);

        ResultActions result = mockMvc.perform(post("/clientes")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isUnprocessableEntity());
        result.andExpect(jsonPath("$.error").value("Validation exception"));
    }

    @Test
    void save_shouldReturnValidationException_whenInputInvalid() throws Exception {
        ClienteDTO validInput = new ClienteDTO(null, "Dayse Galisa", "63276402068", null, null);
        String jsonBody = mapper.writeValueAsString(validInput);

        ResultActions result = mockMvc.perform(post("/clientes")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isUnprocessableEntity());
        result.andExpect(jsonPath("$.error").value("Validation exception"));
    }

    private ClienteDTO[] getClientes(ResultActions result) throws Exception {
        String json = result.andReturn().getResponse().getContentAsString();
        ClienteDTO[] node = mapper.readValue(json, ClienteDTO[].class);
        return node;
    }
}
