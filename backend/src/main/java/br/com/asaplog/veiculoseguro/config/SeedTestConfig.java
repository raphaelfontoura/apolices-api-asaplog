package br.com.asaplog.veiculoseguro.config;

import br.com.asaplog.veiculoseguro.models.embedded.ApoliceNumber;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        Cliente raphael = new Cliente(null, "Raphael Fontoura", "88111717172", "Brasília", "DF", new ArrayList<>());
        Cliente gladson = new Cliente(null, "Gladson Fontoura", "11122233345", "São Luís", "MA", new ArrayList<>());

        clienteRepository.saveAll(Arrays.asList(raphael, gladson));

        Apolice apoliceRaphael = new Apolice(null,
                Math.abs(UUID.randomUUID().getMostSignificantBits()),
                Instant.parse("2020-04-01T14:00:00Z"),
                Instant.parse("2021-04-01T14:00:00Z"),
                "AAA-1122",
                new BigDecimal(2500),
                new ClienteSummary(raphael));
        Apolice apolice2Raphael = new Apolice(null,
                Math.abs(UUID.randomUUID().getMostSignificantBits()),
                Instant.parse("2021-04-02T11:00:00Z"),
                Instant.parse("2022-04-02T11:00:00Z"),
                "AAA-1122",
                new BigDecimal(2700),
                new ClienteSummary(raphael));

        apoliceRepository.saveAll(Arrays.asList(apoliceRaphael, apolice2Raphael));
        var apolice1 = new ApoliceNumber(apoliceRaphael);
        var apolice2 = new ApoliceNumber(apolice2Raphael);
        raphael.getApoliceNumbers().addAll(Arrays.asList(apolice1, apolice2));
        clienteRepository.save(raphael);
    }
}
