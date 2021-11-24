package br.com.asaplog.veiculoseguro.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;
    @NotNull
    private String nomeCompleto;
    @NotNull
    @Indexed(unique = true)
    private String cpf;
    @NotNull
    private String cidade;
    @NotNull
    private String uf;
}