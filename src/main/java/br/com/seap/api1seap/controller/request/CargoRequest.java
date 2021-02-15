package br.com.seap.api1seap.controller.request;

import br.com.seap.api1seap.model.Cargo;
import lombok.Data;

@Data
public class CargoRequest {

    private Long id;

    public Cargo convert() {
        Cargo cargo = new Cargo();
        cargo.setId(id);
        return cargo;
    }
}
