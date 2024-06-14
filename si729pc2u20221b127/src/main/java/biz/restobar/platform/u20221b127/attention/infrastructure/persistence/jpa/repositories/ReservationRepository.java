package biz.restobar.platform.u20221b127.attention.infrastructure.persistence.jpa.repositories;

import biz.restobar.platform.u20221b127.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u20221b127.attention.domain.model.valueobjects.DateReservation;
import biz.restobar.platform.u20221b127.attention.domain.model.valueobjects.NameRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for Reservation
 * <p>
 *     This interface is used to interact with the database.
 *     It extends the JpaRepository interface, which provides CRUD operations.
 *     The entity type is Reservation and the primary key type is Long.
 * </p>
 * @see Reservation
 * @see JpaRepository
 * @see NameRestaurant
 * @see DateReservation
 * @author Salvador Salinas
 * @version 1.0
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    /**
     * Find a reservation by name restaurant and date reservation
     * @param nameRestaurant the name of the restaurant
     * @param dateReservation the date of the reservation
     * @return an optional of reservation
     */
    Optional<Reservation> findByNameRestaurantAndDateReservation(NameRestaurant nameRestaurant, DateReservation dateReservation);
}
