package biz.restobar.platform.u20221b127.attention.domain.model.valueobjects;

import java.util.Date;

/**
 * DateReservation
 * <p>
 *     Value object that represents the date of a reservation.
 * </p>
 * @param date
 * @author Salvador Salinas
 * @version 1.0
 */
public record DateReservation(Date date) {
    /**
     * Constructor of DateReservation
     * @param date Date of the reservation
     */
    public DateReservation {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
    }

    /**
     * Get the date of the reservation
     * @return Date of the reservation
     */
    public Date getDateReservation() {
        return date;
    }
}
