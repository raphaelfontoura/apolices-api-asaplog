package br.com.asaplog.veiculoseguro.models.embedded;

import br.com.asaplog.veiculoseguro.models.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteSummary {
    String id;
    String nomeCompleto;
    String cpf;

    public ClienteSummary(Cliente entity) {
        this.id = entity.getId();
        this.nomeCompleto = entity.getNomeCompleto();
        this.cpf = entity.getCpf();
    }
}
