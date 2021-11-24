package br.com.asaplog.veiculoseguro.models.dto;

import br.com.asaplog.veiculoseguro.models.embedded.ClienteSummary;
import br.com.asaplog.veiculoseguro.models.entities.Apolice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApoliceOutputDTO {
    private String id;
    private Long codigo;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private String placaVeiculo;
    private BigDecimal valor;
    private ClienteSummary cliente;
    private Boolean venceu;
    private Long diasCorridos;

    public ApoliceOutputDTO(Apolice entity) {
        this.id = entity.getId();
        this.codigo = entity.getCodigo();
        this.inicioVigencia = entity.getInicioVigencia();
        this.fimVigencia = entity.getFimVigencia();
        this.placaVeiculo = entity.getPlacaVeiculo();
        this.valor = entity.getValor();
        this.cliente = entity.getCliente();
        var dataAtual = LocalDate.now();
        this.venceu = dataAtual.isAfter(fimVigencia);
        if(venceu) {
            diasCorridos = ChronoUnit.DAYS.between(fimVigencia, dataAtual);
        } else {
            diasCorridos = ChronoUnit.DAYS.between(dataAtual, fimVigencia);
        }
    }
}
