package biz.restobar.platform.u20221b127.attention.application.internal.commandservices;

import biz.restobar.platform.u20221b127.attention.domain.exceptions.ClientNotFoundException;
import biz.restobar.platform.u20221b127.attention.domain.model.aggregates.Reservation;
import biz.restobar.platform.u20221b127.attention.domain.model.commands.CreateReservationCommand;
import biz.restobar.platform.u20221b127.attention.domain.model.valueobjects.CountPerson;
import biz.restobar.platform.u20221b127.attention.domain.model.valueobjects.DateReservation;
import biz.restobar.platform.u20221b127.attention.domain.model.valueobjects.NameRestaurant;
import biz.restobar.platform.u20221b127.attention.domain.services.ReservationCommandService;
import biz.restobar.platform.u20221b127.attention.infrastructure.persistence.jpa.repositories.ClientRepository;
import biz.restobar.platform.u20221b127.attention.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {
    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository, ClientRepository clientRepository) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Reservation> handle(CreateReservationCommand command) {
        // check if client exists
        var client = clientRepository.findById(command.clientId())
                .orElseThrow(() -> new ClientNotFoundException(command.clientId()));

        // check if reservation with same name and date exists
        var nameRestaurant = new NameRestaurant(command.nameRestaurant());
        var dateReservation = new DateReservation(command.dateReservation());
        var reservationExists = reservationRepository.findByNameRestaurantAndDateReservation(nameRestaurant, dateReservation);
        if (reservationExists.isPresent()) {
            throw new IllegalArgumentException("Reservation with Restaurant Name and Reservation Date already exists");
        }


        var countPerson = new CountPerson(command.countPerson());
        var reservation = new Reservation(client, nameRestaurant, dateReservation, countPerson);
        try {
            reservationRepository.save(reservation);
        } catch(Exception e) {
            throw new IllegalArgumentException("Error saving reservation: " + e.getMessage());
        }
        return Optional.of(reservation);
    }
}
