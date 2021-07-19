package ro.cosmin.airports.services;

import ro.cosmin.airports.entities.Flight;
import ro.cosmin.airports.models.FlightDto;
import java.util.List;
import java.util.Optional;


public interface FlightService {

    boolean addFlight(FlightDto flightDto);

    List<FlightDto> retrieveAllFlights();

    Flight updateFlight(Long id);

    boolean deleteFlight(Long id);

    Optional<FlightDto> findById(Long id);

}
