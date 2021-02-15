package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarServidoreUseCase {

    @Autowired
    private ServidorRepository servidorRepository;

    public Optional<Servidor> executar(Long id) {
        return servidorRepository.findOneById(id);
    }
}
