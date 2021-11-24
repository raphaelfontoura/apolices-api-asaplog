package br.com.asaplog.veiculoseguro.models.entities;

import br.com.asaplog.veiculoseguro.models.embedded.ClienteSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Document(collection = "apolices")
public class Apolice {
    @Id
    private String id;
    @NotNull
    private Long codigo;
    @NotNull
    private LocalDate inicioVigencia;
    @NotNull
    private LocalDate fimVigencia;
    @NotNull
    private String placaVeiculo;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private ClienteSummary cliente;
}
