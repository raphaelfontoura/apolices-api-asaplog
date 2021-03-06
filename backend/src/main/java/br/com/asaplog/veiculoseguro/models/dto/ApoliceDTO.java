package br.com.asaplog.veiculoseguro.models.dto;

import br.com.asaplog.veiculoseguro.models.embedded.ClienteSummary;
import br.com.asaplog.veiculoseguro.models.entities.Apolice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
public class ApoliceDTO {
    private String id;
    private Long codigo;
    @NotNull
    private LocalDate inicioVigencia;
    @NotNull
    private LocalDate fimVigencia;
    @NotNull
    private String placaVeiculo;
    @NotNull
    @Positive(message = "Valor da apólice não pode ser zero ou negativo.")
    private BigDecimal valor;
    private ClienteSummary cliente;

    public ApoliceDTO(Apolice entity) {
        this.id = entity.getId();
        this.codigo = entity.getCodigo();
        this.inicioVigencia = entity.getInicioVigencia();
        this.fimVigencia = entity.getFimVigencia();
        this.placaVeiculo = entity.getPlacaVeiculo();
        this.valor = entity.getValor();
        this.cliente = entity.getCliente();
    }

    public Apolice dtoToEntity() {
        return new Apolice(this.id,
                this.codigo,
                this.inicioVigencia,
                this.fimVigencia,
                this.placaVeiculo,
                this.valor,
                this.cliente);
    }
}
