package com.example.airbnb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Optional;

@Data
@Entity
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String surname;

    @ManyToOne
    Country country;

    public Host() {

    }

    public Host(String name, String surname, Country country) {
        this.name=name;
        this.surname=surname;
        this.country=country;
    }
}
