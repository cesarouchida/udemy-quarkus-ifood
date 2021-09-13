package com.clone.ifood.mp;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.Entity;

@Entity
public class PratoCarrinho extends PanacheEntityBase {
    public String usuario;
    public Long prato;
}
