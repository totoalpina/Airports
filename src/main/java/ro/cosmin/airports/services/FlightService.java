package ro.cosmin.airports.services;

import ro.cosmin.airports.models.FlightDto;

import java.util.List;
import java.util.Optional;


public interface FlightService {

    boolean addFlight(FlightDto flightDto);

    List<FlightDto> retrieveAllFlights();

    boolean updateFlight(Long id, FlightDto flightDto);

    boolean deleteFlight(Long id);

    Optional<FlightDto> findById(Long id);

    List<FlightDto> findDepartureFlightByAirport(final Long id);

    List<FlightDto> findArrivalFlightByAirport(final Long id);

}
