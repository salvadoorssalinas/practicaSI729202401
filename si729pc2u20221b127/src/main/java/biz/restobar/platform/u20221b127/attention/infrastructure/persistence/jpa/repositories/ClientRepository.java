package biz.restobar.platform.u20221b127.attention.infrastructure.persistence.jpa.repositories;

import biz.restobar.platform.u20221b127.attention.domain.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for the Client entity.
 * <p>
 *     This interface is used to interact with the database.
 *     It extends the JpaRepository interface, which provides CRUD operations.
 *     The entity type is Client and the primary key type is Long.
 * </p>
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @author Salvador Salinas
 * @version 1.0
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
