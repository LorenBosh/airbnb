package com.example.airbnb.service.impl;

import com.example.airbnb.model.Accommodation;
import com.example.airbnb.model.Host;
import com.example.airbnb.model.dto.AccommodationDTO;
import com.example.airbnb.model.enumerations.Category;
import com.example.airbnb.model.event.AccommodationCreatedEvent;
import com.example.airbnb.model.event.AccommodationDeletedEvent;
import com.example.airbnb.model.event.AccommodationEditedEvent;
import com.example.airbnb.repository.AccommodationRepository;
import com.example.airbnb.service.AccommodationService;
import com.example.airbnb.service.CountryService;
import com.example.airbnb.service.HostService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostService hostService;
    private final CountryService countryService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository,
                                    HostService hostService,
                                    CountryService countryService,
                                    ApplicationEventPublisher applicationEventPublisher) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
        this.countryService = countryService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Accommodation> findAll() {
        return this.accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return this.accommodationRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Accommodation> save(String name, Category category,Long hostId, Integer numRooms) {
        Accommodation accommodation=new Accommodation(name, category, this.hostService.findById(hostId).get(), numRooms);
        this.accommodationRepository.save(accommodation);
        this.applicationEventPublisher.publishEvent(new AccommodationCreatedEvent(accommodation));
        return Optional.of(accommodation);
    }

    @Override
    public Optional<Accommodation> save(AccommodationDTO accommodationDTO) {
        Accommodation accommodation=new Accommodation(
                accommodationDTO.getName(), accommodationDTO.getCategory(),
                this.hostService.findById(accommodationDTO.getHostId()).get(), accommodationDTO.getNumRooms());

        this.accommodationRepository.save(accommodation);
        this.applicationEventPublisher.publishEvent(new AccommodationCreatedEvent(accommodation));
        return Optional.of(accommodation);
    }

    @Override
    @Transactional
    public Optional<Accommodation> edit(Long id, String name, Category category, Long hostId, Integer numRooms) {
        Accommodation accommodation=this.findById(id).get();
        Host host=this.hostService.findById(hostId).get();

        accommodation.setName(name);
        accommodation.setCategory(category);
        accommodation.setHost(host);
        accommodation.setNumRooms(numRooms);

        this.accommodationRepository.save(accommodation);
        this.applicationEventPublisher.publishEvent(new AccommodationEditedEvent(accommodation));

        return Optional.of(accommodation);
    }

    @Override
    public Optional<Accommodation> edit(Long id,AccommodationDTO accommodationDTO) {
        Accommodation accommodation=this.findById(id).get();
        Host host=this.hostService.findById(accommodationDTO.getHostId()).get();

        accommodation.setName(accommodationDTO.getName());
        accommodation.setCategory(accommodationDTO.getCategory());
        accommodation.setHost(host);
        accommodation.setNumRooms(accommodationDTO.getNumRooms());

        this.accommodationRepository.save(accommodation);
        this.applicationEventPublisher.publishEvent(new AccommodationEditedEvent(accommodation));

        return Optional.of(accommodation);
    }

    @Override
    public void deleteById(Long id) {
        Accommodation accommodation= this.findById(id).get();
        this.accommodationRepository.deleteById(id);
        this.applicationEventPublisher.publishEvent(new AccommodationDeletedEvent(accommodation));
    }

    @Override
    public void onAccommodationCreated() {
        System.out.println(" Accommodation created successfully");

    }

    @Override
    public void onAccommodationEdited() {
        System.out.println(" Accommodation edited successfully");

    }

    @Override
    public void onAccommodationDeleted() {
        System.out.println(" Accommodation deleted successfully");

    }


}
