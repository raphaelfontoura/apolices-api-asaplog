package br.com.asaplog.veiculoseguro.services;

import br.com.asaplog.veiculoseguro.models.dto.ApoliceDTO;
import br.com.asaplog.veiculoseguro.models.dto.ApoliceInputDTO;
import br.com.asaplog.veiculoseguro.models.dto.ApoliceOutputDTO;
import br.com.asaplog.veiculoseguro.models.dto.ClienteDTO;
import br.com.asaplog.veiculoseguro.models.embedded.ClienteSummary;
import br.com.asaplog.veiculoseguro.models.entities.Apolice;
import br.com.asaplog.veiculoseguro.models.entities.Cliente;
import br.com.asaplog.veiculoseguro.repositories.ApoliceRepository;
import br.com.asaplog.veiculoseguro.repositories.ClienteRepository;
import br.com.asaplog.veiculoseguro.services.exceptions.ResourceNotFoundException;
import br.com.asaplog.veiculoseguro.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ApoliceService {

    @Autowired
    private ApoliceRepository repository;
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ApoliceDTO> getAll() {
        var apolices = repository.findAll();
        return apolices.stream().map(ApoliceDTO::new).collect(Collectors.toList());
    }

    @Deprecated
    public ApoliceDTO getById(String id) {
        var apolice = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Apólice não encontrada."));
        return new ApoliceDTO(apolice);
    }

    public ApoliceOutputDTO getByCodigo(Long codigo) {
        var apolice = repository.findByCodigo(codigo);
        if (apolice == null) throw new ResourceNotFoundException("Apólice não encontrada.");
        return new ApoliceOutputDTO(apolice);
    }

    @Deprecated
    public ApoliceDTO save(ApoliceDTO dto) {
        Apolice apolice = dto.dtoToEntity();
        apolice.setCodigo(Utils.generateNumber());
        apolice = repository.save(apolice);
        return new ApoliceDTO(apolice);
    }

    public ApoliceDTO save(ApoliceInputDTO dto) {
        Apolice apolice = dto.dtoToEntity();
        Cliente cliente = clienteRepository.findByCpf(Utils.convertCpf(dto.getClienteCpf()));
        if (cliente == null) throw new ResourceNotFoundException("CPF não encontrado.");
        apolice.setCliente(new ClienteSummary(cliente));
        apolice.setCodigo(Utils.generateNumber());
        apolice = repository.save(apolice);
        return new ApoliceDTO(apolice);
    }
}
