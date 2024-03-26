package com.example.airbnb.service.impl;

import com.example.airbnb.model.Country;
import com.example.airbnb.repository.CountryRepository;
import com.example.airbnb.service.CountryService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {


    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        return Optional.of(this.countryRepository.save(new Country(name, continent)));
    }


}
