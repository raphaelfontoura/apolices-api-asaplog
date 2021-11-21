package br.com.asaplog.veiculoseguro.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "tb_clientes")
public class Cliente {
    @Id
    private Long id;
    @NotNull
    private String nomeCompleto;
    @NotNull
    @Column(columnDefinition = "unique")
    private String cpf;
    @NotNull
    private String cidade;
    @NotNull
    private String uf;
}
