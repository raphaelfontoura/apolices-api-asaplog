package br.com.asaplog.veiculoseguro.entities;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
public class Cliente {
    private String id;
    @NotNull
    private String nomeCompleto;
    @NotNull
    private String cpf;
    @NotNull
    private String cidade;
    @NotNull
    private String uf;
    private final Set<Apolice> apolices = new HashSet<>();
}
