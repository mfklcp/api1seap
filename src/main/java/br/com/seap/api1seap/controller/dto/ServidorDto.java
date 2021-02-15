package br.com.seap.api1seap.controller.dto;
import br.com.seap.api1seap.model.Cargo;
import br.com.seap.api1seap.model.Servidor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ServidorDto {

    private String nome;
    private String matricula;
    private LocalDateTime dataCriacao;
    private Set<Cargo> cargos;

    public ServidorDto(Servidor servidor) {
        this.nome = servidor.getNome();
        this.matricula = servidor.getMatricula();
        this.dataCriacao = servidor.getDataCriacao();
        this.cargos = servidor.getListCargos();
    }

    public static List<ServidorDto> converterList(List<Servidor> listaServidor) {
       return listaServidor.stream().map(ServidorDto::new).collect(Collectors.toList());
    }


}
