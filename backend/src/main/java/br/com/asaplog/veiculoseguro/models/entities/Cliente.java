package br.com.asaplog.veiculoseguro.models.entities;

import br.com.asaplog.veiculoseguro.entities.Apolice;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
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
    private final Set<Apolice> apolices = new HashSet<>();
}
