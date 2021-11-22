package br.com.asaplog.veiculoseguro.models.entities;

import br.com.asaplog.veiculoseguro.models.embedded.ApoliceNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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
//    @DBRef(lazy = true)
//    public final List<Apolice> apolices = new ArrayList<>();
    @Transient
    public final List<ApoliceNumber> apoliceNumbers = new ArrayList<>();
}
