package biz.restobar.platform.u20221b127.attention.domain.model.entities;

import biz.restobar.platform.u20221b127.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

/**
 * Client entity
 * <p>
 *     Represents a client that makes a reservation.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */
@Entity
public class Client extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String fullname;

    /**
     * Default constructor for the Client entity
     */
    public Client() {
    }

    /**
     * Constructor with parameters for the Client entity
     * @param fullname Full name of the client
     */
    public Client(String fullname) {
        this.fullname = fullname;
    }

    public Long getId() {
        return id;
    }

}
