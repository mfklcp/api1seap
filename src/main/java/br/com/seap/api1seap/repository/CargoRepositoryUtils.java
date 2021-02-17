package br.com.seap.api1seap.repository;

import br.com.seap.api1seap.model.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class CargoRepositoryUtils {

    @Autowired
    private CargoRepository cargoRepository;

    public Set<Cargo> getListCargosGerenciados(Set<Cargo> cargos){
        Set<Long> ids = cargos.stream().map(Cargo::getId).collect(Collectors.toSet());
        return new HashSet<>(cargoRepository.findAllById(ids));
    }
}
