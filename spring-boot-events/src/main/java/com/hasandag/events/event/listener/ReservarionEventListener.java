package com.hasandag.events.event.listener;

import com.hasandag.events.event.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReservarionEventListener {

    @EventListener
    public void reservationEventHandler(ReservationCreatedEvent reservationCreatedEvent) throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("EventListener -> "+reservationCreatedEvent.getSource());
    }
}
