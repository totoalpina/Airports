package ro.cosmin.airports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cosmin.airports.entities.Flight;
import ro.cosmin.airports.models.FlightDto;
import ro.cosmin.airports.repository.FlightRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

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
                .map(e -> new FlightDto(e.getId(),
                        e.getFlightNumber(),
                        e.getDepartureDate(),
                        e.getArrivalDate(),
                        e.getAirline(),
                        e.getDepartureAirport(),
                        e.getArrivalAirport()))
                .collect(Collectors.toList());
        return flightList;
    }

    @Override
    public Flight updateFlight(Long id) {
        // TODO implementation
        return null;
    }

    @Override
    public boolean deleteFlight(Long id) {
        Optional<Flight> flight = flightService.findById(id)
                .map(e -> new Flight(e.getId(),
                        e.getFlightNumber(),
                        e.getDepartureDate(),
                        e.getArrivalDate(),
                        e.getAirline(),
                        e.getDepartureAirport(),
                        e.getArrivalAirport()));

        flight.ifPresent(f -> flightRepository.deleteById(f.getId()));

        return flight.get().getId() == null;
    }

    @Override
    public Optional<FlightDto> findById(Long id) {
        return flightRepository.findById(id)
                .map(e -> new FlightDto(e.getId(),
                        e.getFlightNumber(),
                        e.getDepartureDate(),
                        e.getArrivalDate(),
                        e.getAirline(),
                        e.getDepartureAirport(),
                        e.getArrivalAirport()));
    }

    @Override
    public List<FlightDto> retrieveFlightsByAirportAndByDate(String airport, String startDate, String endDate) {
        return flightRepository.retrieveFlightsByAirportAndByDate(airport, startDate, endDate)
                .stream()
                .map(e-> new FlightDto(e.getId(),
                        e.getFlightNumber(),
                        e.getDepartureDate(),
                        e.getArrivalDate(),
                        e.getAirline(),
                        e.getDepartureAirport(),
                        e.getArrivalAirport()))
                .collect(Collectors.toList());
    }
}
