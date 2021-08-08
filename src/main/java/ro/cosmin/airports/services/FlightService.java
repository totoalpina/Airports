package ro.cosmin.airports.services;

import ro.cosmin.airports.models.FlightDto;
import ro.cosmin.airports.models.FlightSearchDto;

import java.util.List;
import java.util.Optional;


public interface FlightService {

    boolean addFlight(FlightDto flightDto);

    List<FlightDto> retrieveAllFlights();

    boolean updateFlight(Long id, FlightDto flightDto);

    boolean deleteFlight(Long id);

    Optional<FlightDto> findById(Long id);

    List<FlightSearchDto> findDepartureFlightByAirport(final Long id);

    List<FlightSearchDto> findArrivalFlightByAirport(final Long id);

    List<FlightSearchDto> findFlightByAirline(final Long id);
}
