package com.example.airbnb.model;

import com.example.airbnb.model.enumerations.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Enumerated
    private Category category;

    @ManyToOne
    private Host host;

    Integer numRooms;

    public Accommodation(){

    }

    public Accommodation(String name, Category category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }
}
