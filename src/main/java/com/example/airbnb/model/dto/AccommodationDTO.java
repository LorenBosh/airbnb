package com.example.airbnb.model.dto;


import com.example.airbnb.model.Host;
import com.example.airbnb.model.enumerations.Category;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AccommodationDTO {

    String name;
    Category category;
    Long hostId;
    Integer numRooms;

    public AccommodationDTO(String name, Category category, Long hostId, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.hostId = hostId;
        this.numRooms = numRooms;
    }
    public AccommodationDTO() {

    }
}
