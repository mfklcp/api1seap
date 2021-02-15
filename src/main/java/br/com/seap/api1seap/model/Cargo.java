package br.com.seap.api1seap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity(name = "tb_cargo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cargo {

    //@SequenceGenerator(name="servidor_idcargo_seq", sequenceName = "servidor_idcargor_seq", allocationSize=1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servidor_idcargo_seq")
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo", updatable = false)
    private Long id;
    private String descricao;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "listCargos", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Servidor> listServidores = new HashSet<Servidor>();

    public Cargo(String descricao){
        this.descricao = descricao;
    }

    public Cargo(){}
}

