package br.com.seap.api1seap.usecase;

import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.CargoRepositoryUtils;
import br.com.seap.api1seap.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class CriarServidorUseCase {

    @Autowired
    private ServidorRepository servidorRepository;

    @Autowired
    private CargoRepositoryUtils cargoRepositoryUtils;

    @Transactional
    public Servidor executar(Servidor servidor) {
        Set<Cargo> cargos = cargoRepositoryUtils.getListCargosGerenciados(servidor.getListCargos());
        servidor.setListCargos(cargos);
        return servidorRepository.save(servidor);
    }

}
