package com.example.airbnb.service;

import com.example.airbnb.model.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> listAll();
    Optional<Host> findById(Long id);
    void delete(Long id);
    Optional<Host> create(String name, String surname, Long countryId);
    Optional<Host> update(Long id, String name, String surname, Long countryId);
}
