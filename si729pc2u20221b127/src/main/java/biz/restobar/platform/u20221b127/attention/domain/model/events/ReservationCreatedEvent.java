package biz.restobar.platform.u20221b127.attention.domain.model.events;

import org.springframework.context.ApplicationEvent;

/**
 * Event that represents the creation of a reservation
 * @see org.springframework.context.ApplicationEvent
 * @author Salvador Salinas
 * @version 1.0
 */
public final class ReservationCreatedEvent extends ApplicationEvent {
    private final Long clientId;

    /**
     * Constructor of the ReservationCreatedEvent
     * @param source The source of the event
     * @param clientId The id of the client
     */
    public ReservationCreatedEvent(Object source, Long clientId) {
        super(source);
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
