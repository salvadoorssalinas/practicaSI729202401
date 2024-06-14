package biz.restobar.platform.u20221b127.attention.interfaces.rest.resources;

import java.util.Date;

public record CreateReservationResource(
        String nameRestaurant,
        Long clientId,
        Long countPerson,
        Date dateReservation
) {
}
