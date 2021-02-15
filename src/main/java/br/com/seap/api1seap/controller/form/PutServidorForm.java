package br.com.seap.api1seap.controller.form;

import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import br.com.seap.api1seap.repository.ServidorRepository;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class PutServidorForm {

    private String nome;
    private String matricula;
    private Set<Cargo> listCargos;

    public Servidor atualiza(Long id, ServidorRepository servidorRepository) {
        Servidor servidor = servidorRepository.getOne(id);

        servidor.setNome(this.nome);
        servidor.setNome(this.matricula);
        servidor.setListCargos(this.listCargos);

        return servidor;
    }
    //Só pode atualizar esses 3


}
