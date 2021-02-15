package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BuscarTodosServidoresUseCase {

    @Autowired
    private ServidorRepository servidorRepository;

    public List<Servidor> executar() {
        return servidorRepository.findAll();
    }
}
