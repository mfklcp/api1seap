package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.controller.request.AtualizaServidorRequest;
import br.com.seap.api1seap.controller.request.CargoRequest;
import br.com.seap.api1seap.model.Servidor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AtualizarServidorUseCase {

    public Servidor executar(Servidor value, AtualizaServidorRequest atualizaServidorRequest) {
        value.setNome(atualizaServidorRequest.getNome());
        value.setMatricula(atualizaServidorRequest.getMatricula());
        value.setListCargos(atualizaServidorRequest.getListCargos().stream().map(CargoRequest::convert).collect(Collectors.toSet()));

        return value;
    }
}
