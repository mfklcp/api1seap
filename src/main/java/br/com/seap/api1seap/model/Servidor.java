package br.com.seap.api1seap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.seap.api1seap.model.Cargo;

@Data
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@Entity(name = "tb_servidor")
public class Servidor {

//    @SequenceGenerator(name="servidor_idservidor_seq", sequenceName = "servidor_idservidor_seq", allocationSize=1)
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "servidor_idservidor_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servidor", updatable = false)
    @Id @EqualsAndHashCode.Include
    private Long id;

    private String nome;
    private String matricula;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @JoinTable(name="tb_servidor_cargo",
                joinColumns={@JoinColumn(name="servidor_id")},
                inverseJoinColumns={@JoinColumn(name="cargo_id")})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cargo> listCargos = new HashSet<Cargo>();

    public Servidor(String nome, String matricula, Set<Cargo> cargos) {
        this.nome = nome;
        this.matricula = matricula;
        this.listCargos = cargos;
    }

    public Servidor(){}

}
