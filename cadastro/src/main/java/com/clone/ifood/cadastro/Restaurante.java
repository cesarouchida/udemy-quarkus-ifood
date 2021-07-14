package com.clone.ifood.cadastro;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "restaurante")
public class Restaurante extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    public String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    public Localizacao localizacao;

    public String proprietario;

    // Alterado com o formato com o Mapstuct
    @CreationTimestamp
    public Date dataCriacao;

    // Alterado com o formato com o Mapstuct
    @UpdateTimestamp
    public Date dataAtualizacao;
}
