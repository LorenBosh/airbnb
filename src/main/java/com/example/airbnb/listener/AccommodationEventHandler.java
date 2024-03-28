package com.example.airbnb.listener;


import com.example.airbnb.model.event.AccommodationCreatedEvent;
import com.example.airbnb.model.event.AccommodationEditedEvent;
import com.example.airbnb.model.event.AccommodationFullyBookedEvent;
import com.example.airbnb.service.AccommodationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccommodationEventHandler {

    private final AccommodationService accommodationService;


    public AccommodationEventHandler(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @EventListener
    public void onAccommodationCreated(AccommodationCreatedEvent event) {
        this.accommodationService.onAccommodationCreated();
    }

    @EventListener
    public void onAccommodationEdited(AccommodationEditedEvent event) {
        this.accommodationService.onAccommodationEdited();
    }

    @EventListener
    public void onAccommodationDeleted(AccommodationEditedEvent event) {
        this.accommodationService.onAccommodationEdited();
    }


    @EventListener
    public void onAccommodationFullyBooked(AccommodationFullyBookedEvent event){
        this.accommodationService.onAccommodationFullyBooked();
    }

}
