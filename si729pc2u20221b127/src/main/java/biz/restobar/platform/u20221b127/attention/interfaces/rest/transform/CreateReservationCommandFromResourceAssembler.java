package biz.restobar.platform.u20221b127.attention.interfaces.rest.transform;

import biz.restobar.platform.u20221b127.attention.domain.model.commands.CreateReservationCommand;
import biz.restobar.platform.u20221b127.attention.interfaces.rest.resources.CreateReservationResource;

public class CreateReservationCommandFromResourceAssembler {
    public static CreateReservationCommand toCommandFromResource(CreateReservationResource resource) {
        return new CreateReservationCommand(
                resource.nameRestaurant(),
                resource.clientId(),
                resource.dateReservation(),
                resource.countPerson()
        );
    }
}
