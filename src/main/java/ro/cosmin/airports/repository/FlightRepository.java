package ro.cosmin.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.cosmin.airports.entities.Flight;
import ro.cosmin.airports.models.FlightSearchDto;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("select new ro.cosmin.airports.models.FlightSearchDto(f.id, f.flightNumber, f.departureDate, f.arrivalDate, f.airline, f.departureAirport, f.arrivalAirport) " +
            "from Flight f inner join f.departureAirport inner join f.airline inner join f.arrivalAirport" +
            " where f.departureAirport.id = :id and f.departureDate >= current_date")
    List<FlightSearchDto> findDepartureFlightsByAirportFromCurrentDate(Long id);

    @Query("select new ro.cosmin.airports.models.FlightSearchDto(f.id, f.flightNumber, f.departureDate, f.arrivalDate, f.airline, f.departureAirport, f.arrivalAirport) " +
            "from Flight f inner join f.departureAirport inner join f.airline inner join f.arrivalAirport " +
            " where f.arrivalAirport.id = :id and f.arrivalDate >= current_date")
    List<FlightSearchDto> findArrivalFlightsByAirportFromCurrentDate(Long id);
}
