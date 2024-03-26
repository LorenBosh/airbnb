package com.example.airbnb.service;

import com.example.airbnb.model.Accommodation;
import com.example.airbnb.model.Host;
import com.example.airbnb.model.dto.AccommodationDTO;
import com.example.airbnb.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> findById(Long id);
    Optional<Accommodation> save(String name, Category category, Long hostId, Integer numRooms);
    Optional<Accommodation> save(AccommodationDTO accommodationDTO);
    Optional<Accommodation> edit(Long id, String name, Category category, Long hostId, Integer numRooms);
    Optional<Accommodation> edit(Long id,AccommodationDTO accommodationDTO);
    void deleteById(Long id);

    void onAccommodationCreated();
    void onAccommodationEdited();
    void onAccommodationDeleted();

}

