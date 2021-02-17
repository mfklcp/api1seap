package br.com.seap.api1seap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_servidor")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Servidor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servidor", updatable = false)
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;
    private String matricula;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @JoinTable(name = "tb_servidor_cargo",
            joinColumns = {@JoinColumn(name = "servidor_id")},
            inverseJoinColumns = {@JoinColumn(name = "cargo_id")})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cargo> listCargos = new HashSet<Cargo>();

    public Servidor(String nome, String matricula, Set<Cargo> cargos) {
        this.nome = nome;
        this.matricula = matricula;
        this.listCargos = cargos;
    }

}
