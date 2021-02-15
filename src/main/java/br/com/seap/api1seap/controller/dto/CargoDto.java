package br.com.seap.api1seap.controller.dto;

import br.com.seap.api1seap.model.Cargo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CargoDto {

    private String descricao;

    private CargoDto(Cargo cargo){
        this.descricao = cargo.getDescricao();
    }

    public static List<CargoDto> converteListaCargo(List<Cargo> listCargo) {
        return listCargo.stream().map(CargoDto::new).collect(Collectors.toList());
    }
}
