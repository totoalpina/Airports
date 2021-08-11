package ro.cosmin.airports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cosmin.airports.entities.Flight;
import ro.cosmin.airports.models.FlightDto;
import ro.cosmin.airports.models.FlightSearchDto;
import ro.cosmin.airports.repository.FlightRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    @Override
    public boolean addFlight(final FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setDepartureDate(LocalDateTime.parse(flightDto.getDepartureDate(), dtf));
        flight.setArrivalDate(LocalDateTime.parse(flightDto.getArrivalDate(), dtf));
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
                        e.getDepartureDate().format(dtf),
                        e.getArrivalDate().format(dtf),
                        e.getAirline(),
                        e.getDepartureAirport(),
                        e.getArrivalAirport()))
                .sorted(Comparator.comparing(FlightDto::getFlightNumber))
                .collect(Collectors.toList());
        return flightList;
    }

    @Override
    public boolean updateFlight(final Long id, final FlightDto flightDto) {
        Optional<Flight> flight = flightService.findById(id)
                .map(f -> new Flight(flightDto.getId(),
                        flightDto.getFlightNumber(),
                        LocalDateTime.parse(flightDto.getDepartureDate(), dtf),
                        LocalDateTime.parse(flightDto.getArrivalDate(), dtf),
                        flightDto.getAirline(),
                        flightDto.getDepartureAirport(),
                        flightDto.getArrivalAirport()));
        flight.ifPresent(f -> flightRepository.save(f));

        return flight.get().getFlightNumber() != null;
    }

    @Override
    public boolean deleteFlight(final Long id) {
        Optional<Flight> flight = flightService.findById(id)
                .map(e -> new Flight(e.getId(),
                        e.getFlightNumber(),
                        LocalDateTime.parse(e.getDepartureDate(), dtf),
                        LocalDateTime.parse(e.getArrivalDate(), dtf),
                        e.getAirline(),
                        e.getDepartureAirport(),
                        e.getArrivalAirport()));
        flight.ifPresent(f -> flightRepository.deleteById(f.getId()));

        return flight.get().getId() == null;
    }

    @Override
    public Optional<FlightDto> findById(final Long id) {
        return flightRepository.findById(id)
                .map(e -> new FlightDto(e.getId(),
                        e.getFlightNumber(),
                        e.getDepartureDate().format(dtf),
                        e.getArrivalDate().format(dtf),
                        e.getAirline(),
                        e.getDepartureAirport(),
                        e.getArrivalAirport()));
    }

    @Override
    public List<FlightSearchDto> findDepartureFlightByAirport(final Long id) {
        return flightRepository.findDepartureFlightsByAirportFromCurrentDate(id);
    }

    @Override
    public List<FlightSearchDto> findArrivalFlightByAirport(Long id) {
        return flightRepository.findArrivalFlightsByAirportFromCurrentDate(id);
    }

    @Override
    public List<FlightSearchDto> findFlightByAirline(Long id) {
        return flightRepository.findFlightsByAirlineFromCurrentDate(id);
    }

    @Override
    public List<FlightSearchDto> searchDepartureFlightsByAirportBetweenTwoDates(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        return flightRepository.findDepartureFlightsByAirportBetweenTwoDates(id, startDate, endDate);
    }

    @Override
    public List<FlightSearchDto> searchArrivalFlightsByAirportBetweenTwoDates(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        return flightRepository.findArrivalFlightsByAirportBetweenTwoDates(id, startDate, endDate);
    }

    @Override
    public List<FlightSearchDto> searchFlightsByAirlineBetweenTwoDates(Long id, LocalDateTime startDate, LocalDateTime endDate){
        return flightRepository.findFlightsByAirlineBetweenTwoDates(id, startDate, endDate);
    }
}
