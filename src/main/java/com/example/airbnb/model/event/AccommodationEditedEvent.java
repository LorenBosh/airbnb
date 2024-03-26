package com.example.airbnb.model.event;

import com.example.airbnb.model.Accommodation;
import org.springframework.context.ApplicationEvent;

public class AccommodationEditedEvent extends ApplicationEvent {
    public AccommodationEditedEvent(Accommodation source) {
        super(source);
    }
}
