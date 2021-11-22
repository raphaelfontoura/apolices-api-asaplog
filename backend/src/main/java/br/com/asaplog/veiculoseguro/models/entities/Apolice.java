package br.com.asaplog.veiculoseguro.models.entities;

import br.com.asaplog.veiculoseguro.models.embedded.ClienteSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @NotNull
    private Long codigo;
    @NotNull
    private Instant inicioVigencia;
    @NotNull
    private Instant fimVigencia;
    @NotNull
    private String placaVeiculo;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private ClienteSummary cliente;
}
