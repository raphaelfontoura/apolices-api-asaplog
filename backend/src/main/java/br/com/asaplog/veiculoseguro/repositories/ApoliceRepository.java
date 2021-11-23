package br.com.asaplog.veiculoseguro.repositories;

import br.com.asaplog.veiculoseguro.models.entities.Apolice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApoliceRepository extends MongoRepository<Apolice, String> {
    Apolice findByCodigo(Long codigo);
}
