package com.clone.ifood.mp;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Prato extends PanacheEntity {
    public String nome;
    public String descricao;
    public Restaurante restaurante;
    public BigDecimal preco;
}
