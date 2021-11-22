package br.com.asaplog.veiculoseguro.services;

import br.com.asaplog.veiculoseguro.models.dto.ApoliceDTO;
import br.com.asaplog.veiculoseguro.models.dto.ClienteDTO;
import br.com.asaplog.veiculoseguro.models.entities.Cliente;
import br.com.asaplog.veiculoseguro.repositories.ClienteRepository;
import br.com.asaplog.veiculoseguro.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteDTO> findAll() {
        var result = repository.findAll();
        return result.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public ClienteDTO findById(String id) {
        return new ClienteDTO(getClienteById(id));
    }

    public ClienteDTO save(ClienteDTO dto) {
        Cliente cliente = dto.parseDtoToEntity();
        var result = repository.save(cliente);
        return new ClienteDTO(cliente);
    }

    public ClienteDTO update(String id, ClienteDTO dto) {
        var cliente = getClienteById(id);
        dto.copyDtoToEntity(cliente);
        cliente = repository.save(cliente);
        return new ClienteDTO(cliente);
    }

    public void delete(String id) {
        getClienteById(id);
        repository.deleteById(id);
    }

    private Cliente getClienteById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }
}