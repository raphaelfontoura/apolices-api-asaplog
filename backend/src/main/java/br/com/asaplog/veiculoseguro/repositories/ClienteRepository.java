package br.com.asaplog.veiculoseguro.repositories;

import br.com.asaplog.veiculoseguro.models.entities.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
