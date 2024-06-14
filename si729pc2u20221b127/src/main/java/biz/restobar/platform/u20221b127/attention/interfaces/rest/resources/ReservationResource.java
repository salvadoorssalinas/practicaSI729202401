package biz.restobar.platform.u20221b127.attention.interfaces.rest.resources;

import java.util.Date;

public record ReservationResource(
        Long id,
        String nameRestaurant,
        Long clientId,
        Date dateReservation,
        Long countPerson) {
}
