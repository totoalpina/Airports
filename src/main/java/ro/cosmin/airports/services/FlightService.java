package ro.cosmin.airports.services;

import ro.cosmin.airports.models.FlightDto;

import java.util.List;

public interface FlightService {

    boolean addFlight(FlightDto flightDto);

    List<FlightDto> retrieveAllFlights();

    FlightDto updateFlight(Long id);

    void deleteFlight(Long id);

    FlightDto findById(Long id);
}
