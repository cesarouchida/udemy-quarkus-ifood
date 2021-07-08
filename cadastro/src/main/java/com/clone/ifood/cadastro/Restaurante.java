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

    public String cpnj;

    public String nome;

    @ManyToOne
    public Localizacao localizacao;

    public String proprietario;

    // TODO: Verificar o GMT Brasil
    @CreationTimestamp
    public Date dataCriacao;

    // TODO: Verificar o GMT Brasil
    @UpdateTimestamp
    public Date dataAtualizacao;
}
