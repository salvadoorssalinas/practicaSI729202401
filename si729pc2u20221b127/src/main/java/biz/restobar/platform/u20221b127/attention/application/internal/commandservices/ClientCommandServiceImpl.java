package biz.restobar.platform.u20221b127.attention.application.internal.commandservices;

import biz.restobar.platform.u20221b127.attention.domain.model.commands.CreateClientCommand;
import biz.restobar.platform.u20221b127.attention.domain.model.entities.Client;
import biz.restobar.platform.u20221b127.attention.domain.services.ClientCommandService;
import biz.restobar.platform.u20221b127.attention.infrastructure.persistence.jpa.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientCommandServiceImpl implements ClientCommandService {
    private final ClientRepository clientRepository;

    public ClientCommandServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> handle(CreateClientCommand command) {

        var client = new Client(command.fullname());
        try {
            clientRepository.save(client);
        } catch(Exception e) {
            throw new IllegalArgumentException("Error saving client: " + e.getMessage());
        }
        return Optional.of(client);
    }

}
