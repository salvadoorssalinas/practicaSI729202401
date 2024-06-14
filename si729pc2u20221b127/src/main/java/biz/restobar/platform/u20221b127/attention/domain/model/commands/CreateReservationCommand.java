package biz.restobar.platform.u20221b127.attention.domain.model.commands;

import java.util.Date;

public record CreateReservationCommand(String nameRestaurant, Long clientId, Date dateReservation, Long countPerson) {
}
