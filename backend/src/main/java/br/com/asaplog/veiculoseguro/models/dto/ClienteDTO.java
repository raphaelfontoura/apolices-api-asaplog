package br.com.asaplog.veiculoseguro.models.dto;

import br.com.asaplog.veiculoseguro.models.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Getter @Setter
public class ClienteDTO {
    private String id;
    @NotNull
    private String nomeCompleto;
    @NotNull
    @CPF(message = "CPF inválido")
    private String cpf;
    @NotNull
    private String cidade;
    @NotNull(message = "UF não pode ficar vazio")
    @Pattern(regexp = "^[A-Z]{2}", message = "Digite um UF válido")
    private String uf;

    public ClienteDTO(Cliente entity) {
        this.id = entity.getId();
        this.nomeCompleto = entity.getNomeCompleto();
        this.cpf = entity.getCpf();
        this.cidade = entity.getCidade();
        this.uf = entity.getUf();
    }

    public Cliente parseDtoToEntity() {
        return new Cliente(null,
                this.nomeCompleto,
                this.cpf,
                this.cidade,
                this.uf);
    }

    public void copyDtoToEntity(Cliente entity) {
        entity.setCidade(this.cidade);
        entity.setCpf(this.cpf);
        entity.setNomeCompleto(this.nomeCompleto);
        entity.setUf(this.uf);
    }


}
