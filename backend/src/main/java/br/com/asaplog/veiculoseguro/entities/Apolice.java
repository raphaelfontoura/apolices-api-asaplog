package br.com.asaplog.veiculoseguro.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
public class Apolice {
    @Id
    private String id;
    @GeneratedValue
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
    @ManyToOne
    private Cliente cliente;
}
