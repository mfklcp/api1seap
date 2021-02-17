package br.com.seap.api1seap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_cargo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cargo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "id_cargo", updatable = false)
    private Long id;

    private String descricao;

    @ManyToMany(mappedBy = "listCargos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Servidor> listServidores = new HashSet<Servidor>();

}

