package br.com.asaplog.veiculoseguro.resources;

import br.com.asaplog.veiculoseguro.models.dto.ApoliceDTO;
import br.com.asaplog.veiculoseguro.models.dto.ApoliceInputDTO;
import br.com.asaplog.veiculoseguro.models.dto.ApoliceOutputDTO;
import br.com.asaplog.veiculoseguro.services.ApoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/apolices")
public class ApoliceController {

    @Autowired
    private ApoliceService service;

    @GetMapping
    public ResponseEntity<List<ApoliceDTO>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<ApoliceOutputDTO> getByCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok().body(service.getByCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<ApoliceDTO> save(@Valid @RequestBody ApoliceInputDTO dto) {
        ApoliceDTO apoliceDTO = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(apoliceDTO).toUri();
        return ResponseEntity.created(uri).body(apoliceDTO);
    }

}
