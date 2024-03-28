package com.example.airbnb.model.event;

import com.example.airbnb.model.Accommodation;
import org.springframework.context.ApplicationEvent;

public class AccommodationFullyBookedEvent extends ApplicationEvent {
    public AccommodationFullyBookedEvent(Accommodation source) {
        super(source);
    }
}
