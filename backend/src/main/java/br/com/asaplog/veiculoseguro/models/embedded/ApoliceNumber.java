package br.com.asaplog.veiculoseguro.models.embedded;

import br.com.asaplog.veiculoseguro.models.entities.Apolice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApoliceNumber {
    private String id;
    private Long codigo;

    public ApoliceNumber(Apolice apolice) {
        this.id = apolice.getId();
        this.codigo = apolice.getCodigo();
    }
}
