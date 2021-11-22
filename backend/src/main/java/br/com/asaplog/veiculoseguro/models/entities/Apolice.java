package br.com.asaplog.veiculoseguro.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@Document(collection = "apolices")
public class Apolice {
    @Id
    private String id;

    private UUID codigo;
    @NotNull
    private Instant inicioVigencia;
    @NotNull
    private Instant fimVigencia;
    @NotNull
    private String placaVeiculo;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private Cliente cliente;
}
