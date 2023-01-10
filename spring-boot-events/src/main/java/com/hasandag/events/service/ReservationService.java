package com.hasandag.events.service;

import com.hasandag.events.api.BookingApi;
import com.hasandag.events.api.HotelBookRequest;
import com.hasandag.events.event.ReservationCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publishReservationService(HotelBookRequest hotelBookRequest){
        applicationEventPublisher.publishEvent(new ReservationCreatedEvent(hotelBookRequest));
    }
}
