package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeletarServidoreUseCase {

    @Autowired
    private ServidorRepository servidorRepository;

    public void executar(Long id) {
        servidorRepository.deleteById(id);
    }
}
