package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.CargoRepositoryUtils;
import br.com.seap.api1seap.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Set;


@Service
public class AtualizarServidorUseCase {

    @Autowired
    private ServidorRepository servidorRepository;

    @Autowired
    private CargoRepositoryUtils cargoRepositoryUtils;

    @Transactional
    public Servidor executar(Servidor servidorNovosDados) {
        Servidor servidorGerenciado = servidorRepository.
                findById(servidorNovosDados.getId()).orElseThrow(NoSuchElementException::new);
        Set<Cargo> novosCargos = cargoRepositoryUtils.getListCargosGerenciados(servidorNovosDados.getListCargos());
        servidorGerenciado = atualizaDados(servidorGerenciado, servidorNovosDados, novosCargos);
        return servidorRepository.save(servidorGerenciado);
    }

    public Servidor atualizaDados(Servidor servidorGerenciado, Servidor servidorNovosDados, Set<Cargo> novosCargos){
        servidorGerenciado.setNome(servidorNovosDados.getNome());
        servidorGerenciado.setMatricula(servidorNovosDados.getMatricula());
        servidorGerenciado.getListCargos().clear();
        novosCargos.forEach(cargo -> servidorGerenciado.getListCargos().add(cargo));
        return servidorGerenciado;
    }
}

