package ro.cosmin.airports.services;

import ro.cosmin.airports.entities.Flight;
import ro.cosmin.airports.models.FlightDto;
import ro.cosmin.airports.models.FlightSearchDto;

import java.time.LocalDateTime;
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

    List<FlightSearchDto> searchDepartureFlightsByAirportBetweenTwoDates(Long id, LocalDateTime startDate, LocalDateTime endDate);

    List<FlightSearchDto> searchArrivalFlightsByAirportBetweenTwoDates(Long id, LocalDateTime startDate, LocalDateTime endDate);

    List<FlightSearchDto> searchFlightsByAirlineBetweenTwoDates(Long id, LocalDateTime startDate, LocalDateTime endDate);
}
