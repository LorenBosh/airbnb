package com.example.airbnb.model.event;

import com.example.airbnb.model.Accommodation;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class AccommodationCreatedEvent extends ApplicationEvent {
    public AccommodationCreatedEvent(Accommodation source) {
        super(source);
    }
}
