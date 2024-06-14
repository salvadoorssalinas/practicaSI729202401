package biz.restobar.platform.u20221b127.attention.interfaces.rest;

import biz.restobar.platform.u20221b127.attention.domain.model.queries.GetAllReservationsQuery;
import biz.restobar.platform.u20221b127.attention.domain.services.ReservationCommandService;
import biz.restobar.platform.u20221b127.attention.domain.services.ReservationQueryService;
import biz.restobar.platform.u20221b127.attention.interfaces.rest.resources.CreateReservationResource;
import biz.restobar.platform.u20221b127.attention.interfaces.rest.resources.ReservationResource;
import biz.restobar.platform.u20221b127.attention.interfaces.rest.transform.CreateReservationCommandFromResourceAssembler;
import biz.restobar.platform.u20221b127.attention.interfaces.rest.transform.ReservationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ReservationsController
 * <p>
 *     Controller for the Reservations endpoints.
 *     This controller handles the creation and retrieval of reservations.
 * </p>
 * @see ReservationCommandService
 * @see ReservationQueryService
 * @author Salvador Salinas
 * @version 1.0
 */

@RestController
@RequestMapping(value = "api/v1/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Reservations", description = "Reservations Endpoints")
public class ReservationsController {
    private final ReservationCommandService reservationCommandService;
    private final ReservationQueryService reservationQueryService;

    public ReservationsController(ReservationCommandService reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    @Operation(summary = "Get all reservations", description = "Get all reservations created")
    @GetMapping
    public ResponseEntity<List<ReservationResource>> getAllReservations() {
        var getAllReservationsQuery = new GetAllReservationsQuery();
        var reservations = reservationQueryService.handle(getAllReservationsQuery);
        var reservationResources = reservations.stream()
                .map(ReservationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(reservationResources);
    }

    /**
     * Create a reservation with the given data
     * @param resource The data to create the reservation
     * @return The created reservation
     */
    @Operation(summary = "Create a reservation", description = "Create a new reservation")
    @PostMapping
    public ResponseEntity<ReservationResource> createReservation(@RequestBody CreateReservationResource resource) {
        var createReservationCommand = CreateReservationCommandFromResourceAssembler.toCommandFromResource(resource);
        var reservation = reservationCommandService.handle(createReservationCommand);
        if (reservation.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var reservationResource = ReservationResourceFromEntityAssembler.toResourceFromEntity(reservation.get());
        return new ResponseEntity<>(reservationResource, HttpStatus.CREATED);

    }

}
