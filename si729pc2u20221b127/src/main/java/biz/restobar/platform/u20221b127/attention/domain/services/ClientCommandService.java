package biz.restobar.platform.u20221b127.attention.domain.services;

import biz.restobar.platform.u20221b127.attention.domain.model.commands.CreateClientCommand;
import biz.restobar.platform.u20221b127.attention.domain.model.entities.Client;

import java.util.Optional;

/**
 * ClientCommandService
 * <p>
 *     This interface represents the service that handles the commands related to the clients.
 * </p>
 * @see CreateClientCommand
 * @author Salvador Salinas
 * @version 1.0
 */
public interface ClientCommandService {
    Optional<Client> handle(CreateClientCommand command);
}
