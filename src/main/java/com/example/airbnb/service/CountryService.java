package com.example.airbnb.service;

import com.example.airbnb.model.Country;
import com.example.airbnb.model.Host;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> listAll();
    Optional<Country> findById(Long id);
    void deleteById(Long id);
    Optional<Country> save(String name, String continent);
}
