package br.com.asaplog.veiculoseguro.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;
    @NotNull
    private String nomeCompleto;
    @NotNull
    private String cpf;
    @NotNull
    private String cidade;
    @NotNull
    private String uf;
    @DBRef(lazy = true)
    public final List<Apolice> apolices = new ArrayList<>();
}
