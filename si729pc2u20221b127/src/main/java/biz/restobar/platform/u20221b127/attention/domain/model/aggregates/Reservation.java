package biz.restobar.platform.u20221b127.attention.domain.model.aggregates;

import biz.restobar.platform.u20221b127.attention.domain.model.entities.Client;
import biz.restobar.platform.u20221b127.attention.domain.model.valueobjects.CountPerson;
import biz.restobar.platform.u20221b127.attention.domain.model.valueobjects.DateReservation;
import biz.restobar.platform.u20221b127.attention.domain.model.valueobjects.NameRestaurant;
import biz.restobar.platform.u20221b127.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

/**
 * Reservation
 * <p>
 *     Represents a reservation made by a client.
 * </p>
 * @see Client
 * @see NameRestaurant
 * @see DateReservation
 * @see CountPerson
 * @see AuditableAbstractAggregateRoot
 * @author Salvador Salinas
 * @version 1.0
 */
@Entity
public class Reservation extends AuditableAbstractAggregateRoot<Reservation> {
    @ManyToOne
    @JoinColumn(nullable = false, name = "client_id")
    private Client client;

    @Embedded
    @NotNull(message = "Name restaurant is required")
    private NameRestaurant nameRestaurant;

    @Embedded
    @NotNull(message = "Date reservation is required")
    private DateReservation dateReservation;

    @Embedded
    @NotNull(message = "Count person is required")
    private CountPerson countPerson;

    public Reservation() {
    }

    public Reservation(Client client, NameRestaurant nameRestaurant, DateReservation dateReservation, CountPerson countPerson) {
        this.client = client;
        this.nameRestaurant = nameRestaurant;
        this.dateReservation = dateReservation;
        this.countPerson = countPerson;
    }

    public Client getClient() {
        return client;
    }

    public String getNameRestaurant() {
        return nameRestaurant.getNameRestaurant();
    }

    public Date getDateReservation() {
        return dateReservation.getDateReservation();
    }

    public Long getCountPerson() {
        return countPerson.getCountPerson();
    }

}
