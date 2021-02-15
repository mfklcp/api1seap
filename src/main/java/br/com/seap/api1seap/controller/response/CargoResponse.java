package br.com.seap.api1seap.controller.response;

import br.com.seap.api1seap.model.Cargo;

import java.util.List;
import java.util.stream.Collectors;

public class CargoResponse {

    private String descricao;

    private CargoResponse(Cargo cargo){
        this.descricao = cargo.getDescricao();
    }

    public static List<CargoResponse> converteListaCargo(List<Cargo> listCargo) {
        return listCargo.stream().map(CargoResponse::new).collect(Collectors.toList());
    }
}
