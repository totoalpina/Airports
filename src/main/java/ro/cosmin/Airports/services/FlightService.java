package ro.cosmin.Airports.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.cosmin.Airports.models.FlightDto;

import java.util.List;

public interface FlightService {

    boolean addFlight(FlightDto flightDto);

    List<FlightDto> retrieveAllFlights();

    Page<FlightDto> retrieveAllFlights(Pageable pageable);

    FlightDto updateFlight(Long id);

    void deleteFlight(Long id);

    FlightDto findById(Long id);
}
