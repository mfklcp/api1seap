package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.model.Servidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AtualizarServidorUseCase {

    @Autowired
    private DefindeDadosServidorUseCase defindeDadosServidorUseCase;

    public Servidor executar(Servidor servidor) {
        defindeDadosServidorUseCase.executar(servidor);
        return servidor;
    }
}

