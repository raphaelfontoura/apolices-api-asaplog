package br.com.asaplog.veiculoseguro.models.dto;

import br.com.asaplog.veiculoseguro.models.entities.Apolice;
import br.com.asaplog.veiculoseguro.utils.Utils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
public class ApoliceInputDTO {
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
    private String clienteCpf;

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = Utils.convertCpf(clienteCpf);
    }

    public Apolice dtoToEntity() {
        return new Apolice(this.id,
                this.codigo,
                this.inicioVigencia,
                this.fimVigencia,
                this.placaVeiculo,
                this.valor,
                null);
    }
}
