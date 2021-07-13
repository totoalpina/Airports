package ro.cosmin.Airports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.cosmin.Airports.domain.Flight;
import ro.cosmin.Airports.models.FlightDto;
import ro.cosmin.Airports.repository.FlightRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public boolean addFlight(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setArrivalDate(flightDto.getArrivalDate());
        flight.setAirline(flightDto.getAirline());
        flight.setDepartureAirport(flightDto.getDepartureAirport());
        flight.setArrivalAirport(flightDto.getArrivalAirport());

        flightRepository.save(flight);
        return flight.getId() != null;
    }

    @Override
    public List<FlightDto> retrieveAllFlights() {
        List<FlightDto> flightList = flightRepository.findAll()
                .stream()
                .map(e -> new FlightDto(e.getFlightNumber(),
                        e.getDepartureDate(),
                        e.getArrivalDate(),
                        e.getAirline(),
                        e.getDepartureAirport(),
                        e.getArrivalAirport()))
                .collect(Collectors.toList());
        return flightList;
    }

    @Override
    public Page<FlightDto> retrieveAllFlights(Pageable pageable) {
        // TODO implementation
        return null;
    }

    @Override
    public FlightDto updateFlight(Long id) {
        // TODO implementation
        return null;
    }

    @Override
    public boolean deleteFlight(Long id) {
        // TODO implementation
        return false;
    }

    @Override
    public FlightDto findById(Long id) {
        // TODO implementation
        return null;
    }
}