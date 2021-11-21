package br.com.asaplog.veiculoseguro.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
public class Cliente {
    @Id
    private String id;
    @NotNull
    private String nomeCompleto;
    @NotNull
    @Column(unique = true)
    private String cpf;
    @NotNull
    private String cidade;
    @NotNull
    private String uf;
    private final Set<Apolice> apolices = new HashSet<>();
}
