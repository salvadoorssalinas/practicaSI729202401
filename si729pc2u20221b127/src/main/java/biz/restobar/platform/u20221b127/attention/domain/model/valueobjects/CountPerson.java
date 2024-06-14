package biz.restobar.platform.u20221b127.attention.domain.model.valueobjects;

/**
 * CountPerson
 * <p>
 *     Value object that represents the number of people in a reservation.
 * </p>
 * @param count
 * @author Salvador Salinas
 * @version 1.0
 */
public record CountPerson(Long count) {
    /**
     * Constructor for CountPerson
     * @param count The number of people in the reservation
     */
    public CountPerson {
        if (count == null || count < 1) {
            throw new IllegalArgumentException("Count cannot be null or less than 1");
        }
    }

    /**
     * Get the number of people in the reservation
     * @return The number of people in the reservation
     */
    public Long getCountPerson() {
        return count;
    }
}
