package biz.restobar.platform.u20221b127.attention.domain.services;

import biz.restobar.platform.u20221b127.attention.domain.model.entities.Client;
import biz.restobar.platform.u20221b127.attention.domain.model.queries.GetAllClientsQuery;
import biz.restobar.platform.u20221b127.attention.domain.model.queries.GetClientByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ClientQueryService {
    List<Client> handle(GetAllClientsQuery query);
    Optional<Client> handle(GetClientByIdQuery query);
}
