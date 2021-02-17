package br.com.seap.api1seap.controller.response;

import br.com.seap.api1seap.model.Servidor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServidorResponse {

    private String nome;
    private String matricula;
    private LocalDateTime dataCriacao;
    private Set<CargoResponse> cargos = new HashSet<>();

    public ServidorResponse(Servidor servidor) {
        this.nome = servidor.getNome();
        this.matricula = servidor.getMatricula();
        this.dataCriacao = servidor.getDataCriacao();
        this.cargos = servidor.getListCargos().stream().map(CargoResponse::new).collect(Collectors.toSet());
    }

    public static List<ServidorResponse> converterList(List<Servidor> listaServidor) {
        return listaServidor.stream().map(ServidorResponse::new).collect(Collectors.toList());
    }


}
