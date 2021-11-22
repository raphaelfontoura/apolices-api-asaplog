package br.com.asaplog.veiculoseguro.resources;

import br.com.asaplog.veiculoseguro.models.dto.ApoliceDTO;
import br.com.asaplog.veiculoseguro.services.ApoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApoliceDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.getById(id));
    }
}
