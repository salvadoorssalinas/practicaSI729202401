package biz.restobar.platform.u20221b127.attention.interfaces.rest.transform;

import biz.restobar.platform.u20221b127.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u20221b127.attention.interfaces.rest.resources.ReservationResource;

public class ReservationResourceFromEntityAssembler {
    public static ReservationResource toResourceFromEntity(Reservation entity) {
        return new ReservationResource(
                entity.getId(),
                entity.getNameRestaurant(),
                entity.getClient().getId(),
                entity.getDateReservation(),
                entity.getCountPerson()
        );
    }
}
