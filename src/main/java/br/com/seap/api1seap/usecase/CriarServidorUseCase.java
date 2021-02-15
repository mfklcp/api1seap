package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.CargoRepository;
import br.com.seap.api1seap.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private CargoRepository cargoRepository;


    public Servidor executar(Servidor servidor){
        Set<Long> ids = servidor.getListCargos().stream().map(Cargo::getId).collect(Collectors.toSet());
        Set<Cargo> cargos = new HashSet<>(cargoRepository.findAllById(ids));
        servidor.setListCargos(cargos);
        return servidorRepository.save(servidor);
    }
}
