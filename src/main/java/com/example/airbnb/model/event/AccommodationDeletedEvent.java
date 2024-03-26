package com.example.airbnb.model.event;

import com.example.airbnb.model.Accommodation;
import org.springframework.context.ApplicationEvent;

public class AccommodationDeletedEvent extends ApplicationEvent {
    public AccommodationDeletedEvent(Accommodation source) {
        super(source);
    }
}
