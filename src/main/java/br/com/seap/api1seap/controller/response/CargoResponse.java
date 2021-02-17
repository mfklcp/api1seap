package br.com.seap.api1seap.controller.response;

import br.com.seap.api1seap.model.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoResponse {

    private Long id;
    private String descricao;

    public CargoResponse(Cargo cargo) {
        this.descricao = cargo.getDescricao();
        this.id = cargo.getId();
    }

}
