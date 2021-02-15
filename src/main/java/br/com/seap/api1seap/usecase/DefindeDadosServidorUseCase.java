package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DefindeDadosServidorUseCase {

    @Autowired
    private CargoRepository cargoRepository;

    @Transactional
    public Servidor executar(Servidor servidor) {
        Set<Long> ids = servidor.getListCargos().stream().map(Cargo::getId).collect(Collectors.toSet());
        Set<Cargo> cargos = new HashSet<>(cargoRepository.findAllById(ids));
        servidor.setListCargos(cargos);
        return servidor;
    }
}
