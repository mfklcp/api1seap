package br.com.seap.api1seap.controller.form;

import br.com.seap.api1seap.controller.request.CargoRequest;
import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import lombok.Data;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ServidorForm {

    private String nome;
    private String matricula;
    private Set<CargoRequest> cargos;

    public Servidor converter() {
        return new Servidor(this.nome, this.matricula, cargos.stream().map(CargoRequest::convert).collect(Collectors.toSet()));
    }
}
