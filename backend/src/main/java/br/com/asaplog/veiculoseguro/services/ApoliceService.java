package br.com.asaplog.veiculoseguro.services;

import br.com.asaplog.veiculoseguro.models.dto.ApoliceDTO;
import br.com.asaplog.veiculoseguro.repositories.ApoliceRepository;
import br.com.asaplog.veiculoseguro.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApoliceService {

    @Autowired
    private ApoliceRepository repository;

    public List<ApoliceDTO> getAll() {
        var apolices = repository.findAll();
        return apolices.stream().map(apolice -> new ApoliceDTO(apolice)).collect(Collectors.toList());
    }

    public ApoliceDTO getById(String id) {
        var apolice = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Apólice não encontrada."));
        return new ApoliceDTO(apolice);
    }
}
