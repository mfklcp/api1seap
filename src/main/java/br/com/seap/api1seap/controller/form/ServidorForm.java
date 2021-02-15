package br.com.seap.api1seap.controller.form;

import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import lombok.Setter;

import java.util.Set;

@Setter
public class ServidorForm {

    private String nome;
    private String matricula;
    private Set<Cargo> cargos;

    public Servidor converter() {
        return new Servidor(this.nome, this.matricula, this.cargos);
    }
}
