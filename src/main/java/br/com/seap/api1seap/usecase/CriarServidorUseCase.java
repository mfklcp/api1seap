package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.CargoRepository;
import br.com.seap.api1seap.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CriarServidorUseCase {

    @Autowired
    private ServidorRepository servidorRepository;

    @Autowired
    private DefindeDadosServidorUseCase defindeDadosServidorUseCase;

    @Transactional
    public Servidor executar(Servidor servidor){
        defindeDadosServidorUseCase.executar(servidor);
        return servidorRepository.save(servidor);
    }
}
