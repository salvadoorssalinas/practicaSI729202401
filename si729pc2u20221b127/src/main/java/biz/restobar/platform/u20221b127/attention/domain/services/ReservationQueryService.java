package biz.restobar.platform.u20221b127.attention.domain.services;

import biz.restobar.platform.u20221b127.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u20221b127.attention.domain.model.queries.GetAllReservationsQuery;
import biz.restobar.platform.u20221b127.attention.domain.model.queries.GetReservationByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * ReservationQueryService
 * <p>
 *     Service interface for handling reservation queries.
 *     This interface is used to define the methods that will be implemented by the service class.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */
public interface ReservationQueryService {
    List<Reservation> handle(GetAllReservationsQuery query);
    Optional<Reservation> handle(GetReservationByIdQuery query);
}
