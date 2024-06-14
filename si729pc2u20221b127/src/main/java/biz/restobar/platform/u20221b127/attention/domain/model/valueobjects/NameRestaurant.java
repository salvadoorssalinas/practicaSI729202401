package biz.restobar.platform.u20221b127.attention.domain.model.valueobjects;

/**
 * NameRestaurant
 * <p>
 *     Value object that represents the name of the restaurant.
 * </p>
 * @param name
 * @author Salvador Salinas
 * @version 1.0
 */
public record NameRestaurant(String name) {
    /**
     * Constructor of the NameRestaurant value object.
     * @param name Name of the restaurant.
     */
    public NameRestaurant {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (name.length() > 50) {
            throw new IllegalArgumentException("Name cannot be longer than 50 characters");
        }
    }

    /**
     * Get the name of the restaurant.
     * @return Name of the restaurant.
     */
    public String getNameRestaurant() {
        return name;
    }
}
