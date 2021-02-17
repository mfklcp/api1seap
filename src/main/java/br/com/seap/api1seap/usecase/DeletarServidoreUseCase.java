package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;


@Service
public class DeletarServidoreUseCase {

    @Autowired
    private ServidorRepository servidorRepository;

    @Transactional
    public void executar(Long id) {
        Servidor servidor = servidorRepository.findById(id).orElseThrow(NoSuchElementException::new);
        servidorRepository.delete(servidor);
    }
}
