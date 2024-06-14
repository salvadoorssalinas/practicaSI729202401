package biz.restobar.platform.u20221b127.attention.application.internal.eventhandlers;

import biz.restobar.platform.u20221b127.attention.domain.model.commands.CreateClientCommand;
import biz.restobar.platform.u20221b127.attention.domain.model.queries.GetAllClientsQuery;
import biz.restobar.platform.u20221b127.attention.domain.services.ClientCommandService;
import biz.restobar.platform.u20221b127.attention.domain.services.ClientQueryService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * This class listens to the ApplicationReadyEvent and creates clients if there are none
 * in the system.
 * @see ApplicationReadyEvent
 * @see ClientCommandService
 * @see ClientQueryService
 * @author Salvador Salinas
 * @version 1.0
 */
@Service
public class ApplicationReadyEventHandler {
    private final ClientQueryService clientQueryService;
    private final ClientCommandService clientCommandService;

    public ApplicationReadyEventHandler(ClientQueryService clientQueryService, ClientCommandService clientCommandService) {
        this.clientQueryService = clientQueryService;
        this.clientCommandService = clientCommandService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void on() {
        var getAllClientsQuery = new GetAllClientsQuery();
        var clients = clientQueryService.handle(getAllClientsQuery);
        if (clients.isEmpty()) {
            clientCommandService.handle(new CreateClientCommand("Mark Miller"));
            clientCommandService.handle(new CreateClientCommand("Luisa Smith"));
            System.out.println("Clients created");
        }
        else {
            System.out.println("Clients already exist");
        }
    }

}
