package com.example.airbnb.service.impl;

import com.example.airbnb.model.Host;
import com.example.airbnb.repository.HostRepository;
import com.example.airbnb.service.CountryService;
import com.example.airbnb.service.HostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl  implements HostService {

    private final HostRepository hostRepository;
    private final CountryService countryService;

    public HostServiceImpl(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Host> listAll() {
        return this.hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return this.hostRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.hostRepository.deleteById(id);
    }

    @Override
    public Optional<Host> create(String name, String surname, Long countryId) {
        return Optional.of(this.hostRepository.save(
                        new Host(name, surname, this.countryService.findById(countryId).get())));
    }

    @Override
    public Optional<Host> update(Long id, String name, String surname, Long countryId) {
        Host host= this.findById(id).get();
        host.setCountry(this.countryService.findById(countryId).get());
        host.setName(name);
        host.setSurname(surname);

        this.hostRepository.save(host);
        return Optional.of(host);
    }
}
