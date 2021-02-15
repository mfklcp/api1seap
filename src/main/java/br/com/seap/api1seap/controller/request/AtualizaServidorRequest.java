package br.com.seap.api1seap.controller.request;

import br.com.seap.api1seap.controller.request.CargoRequest;
import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.ServidorRepository;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class AtualizaServidorRequest {

    private String nome;
    private String matricula;
    private Set<CargoRequest> listCargos;

    public Servidor atualiza(Long id, ServidorRepository servidorRepository) {
        Servidor servidor = servidorRepository.getOne(id);

        servidor.setNome(this.nome);
        servidor.setNome(this.matricula);
        servidor.setListCargos(this.listCargos.stream().map(CargoRequest::convert).collect(Collectors.toSet()));

        return servidor;
    }
    //Só pode atualizar esses 3


}
