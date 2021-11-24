package br.com.asaplog.veiculoseguro.config;

import br.com.asaplog.veiculoseguro.models.embedded.ClienteSummary;
import br.com.asaplog.veiculoseguro.models.entities.Apolice;
import br.com.asaplog.veiculoseguro.models.entities.Cliente;
import br.com.asaplog.veiculoseguro.repositories.ApoliceRepository;
import br.com.asaplog.veiculoseguro.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

@Configuration
@Profile("test")
public class SeedTestConfig {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ApoliceRepository apoliceRepository;

    @PostConstruct
    public void init() {
        clienteRepository.deleteAll();
        apoliceRepository.deleteAll();

        Cliente raphael = new Cliente(null, "Raphael Fontoura", "699.605.490-70", "Brasília", "DF");
        Cliente gladson = new Cliente(null, "Gladson Fontoura", "090.304.920-15", "São Luís", "MA");

        clienteRepository.saveAll(Arrays.asList(raphael, gladson));

        Apolice apoliceRaphael = new Apolice(null,
                Math.abs(UUID.randomUUID().getMostSignificantBits()),
                LocalDate.parse("2020-04-01"),
                LocalDate.parse("2021-04-01"),
                "AAA-1122",
                new BigDecimal(2500),
                new ClienteSummary(raphael));
        Apolice apolice2Raphael = new Apolice(null,
                Math.abs(UUID.randomUUID().getMostSignificantBits()),
                LocalDate.parse("2021-04-02"),
                LocalDate.parse("2022-04-02"),
                "AAA-1122",
                new BigDecimal(2700),
                new ClienteSummary(raphael));

        apoliceRepository.saveAll(Arrays.asList(apoliceRaphael, apolice2Raphael));

    }
}
