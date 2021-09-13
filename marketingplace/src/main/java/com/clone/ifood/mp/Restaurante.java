package com.clone.ifood.mp;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Restaurante extends PanacheEntity {
    public String nome;
    public Localizacao localizacao;


}
