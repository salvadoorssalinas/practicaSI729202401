package biz.restobar.platform.u20221b127.attention.application.internal.eventhandlers;

import biz.restobar.platform.u20221b127.attention.domain.model.events.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * This class listens to the ReservationCreatedEvent and logs the client id that created the reservation.
 * @see ReservationCreatedEvent
 * @author Salvador Salinas
 * @version 1.0
 */
@Service
public class ReservationCreatedEventHandler {
    @EventListener(ReservationCreatedEvent.class)
    public void on(ReservationCreatedEvent event) {
        System.out.println("Reservation created for client with id: " + event.getClientId());
    }
}
