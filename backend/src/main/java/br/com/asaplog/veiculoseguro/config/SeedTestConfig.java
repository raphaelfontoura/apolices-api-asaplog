package br.com.asaplog.veiculoseguro.config;

import br.com.asaplog.veiculoseguro.models.entities.Cliente;
import br.com.asaplog.veiculoseguro.repositories.ApoliceRepository;
import br.com.asaplog.veiculoseguro.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.util.Arrays;

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

        Cliente raphael = new Cliente(null, "Raphael Fontoura", "88111717172", "Brasília", "DF");
        Cliente gladson = new Cliente(null, "Gladson Fontoura", "11122233345", "São Luís", "MA");

        clienteRepository.saveAll(Arrays.asList(raphael, gladson));
    }
}
