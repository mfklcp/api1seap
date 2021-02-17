package br.com.seap.api1seap.controller.request;

import br.com.seap.api1seap.controller.request.CargoRequest;
import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.ServidorRepository;
import lombok.Data;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class AtualizaServidorRequest {

    private String nome;
    private String matricula;
    private Set<CargoRequest> listCargos;

    public Servidor convert() {
        Servidor servidor = new Servidor();
        servidor.setNome(this.nome);
        servidor.setMatricula(this.matricula);
        servidor.setListCargos(this.listCargos.stream().map(CargoRequest::convert).collect(Collectors.toSet()));
        return servidor;
    }




}
