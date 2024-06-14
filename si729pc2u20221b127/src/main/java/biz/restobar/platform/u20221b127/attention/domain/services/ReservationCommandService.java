package biz.restobar.platform.u20221b127.attention.domain.services;

import biz.restobar.platform.u20221b127.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u20221b127.attention.domain.model.commands.CreateReservationCommand;

import java.util.Optional;

/**
 * ReservationCommandService
 * <p>
 *     This interface represents the service that handles the commands related to the reservations.
 * </p>
 * @see CreateReservationCommand
 * @author Salvador Salinas
 * @version 1.0
 */
public interface ReservationCommandService {
    Optional<Reservation> handle(CreateReservationCommand command);
}
