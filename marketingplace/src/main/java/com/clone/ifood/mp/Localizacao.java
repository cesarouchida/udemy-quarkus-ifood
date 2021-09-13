package com.clone.ifood.mp;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Localizacao extends PanacheEntity {
    public Double latitude;
    public Double longitude;
}
