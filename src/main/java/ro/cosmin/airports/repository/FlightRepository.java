package ro.cosmin.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.cosmin.airports.entities.Flight;
import ro.cosmin.airports.models.FlightSearchDto;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("select new ro.cosmin.airports.models.FlightSearchDto(f.id, f.flightNumber, f.departureDate, f.arrivalDate, f.airline, f.departureAirport, f.arrivalAirport) " +
            "from Flight f inner join f.departureAirport depAirport " +
            " where depAirport.id = :id and f.departureDate between current_date and current_date+1" +
            " order by f.departureDate")
    List<FlightSearchDto> findDepartureFlightsByAirportFromCurrentDate(Long id);

    @Query("select new ro.cosmin.airports.models.FlightSearchDto(f.id, f.flightNumber, f.departureDate, f.arrivalDate, f.airline, f.departureAirport, f.arrivalAirport) " +
            "from Flight f inner join f.arrivalAirport arrAirport" +
            " where arrAirport.id = :id and f.arrivalDate between current_date and current_date+1 " +
            " order by f.arrivalDate")
    List<FlightSearchDto> findArrivalFlightsByAirportFromCurrentDate(Long id);

    @Query("select new ro.cosmin.airports.models.FlightSearchDto(f.id, f.flightNumber, f.departureDate, f.arrivalDate, f.airline, f.departureAirport, f.arrivalAirport) " +
            "from Flight f inner join f.departureAirport inner join f.airline inner join f.arrivalAirport " +
            " where f.airline.id = :id and f.arrivalDate between current_date and current_date+1 and f.departureDate between current_date and current_date+1" +
            " order by f.departureDate")
    List<FlightSearchDto> findFlightsByAirlineFromCurrentDate(Long id);

    @Query("select new ro.cosmin.airports.models.FlightSearchDto(f.id, f.flightNumber, f.departureDate, f.arrivalDate, f.airline, f.departureAirport, f.arrivalAirport) " +
            "from Flight f " +
            "where f.departureAirport.id = :id and f.departureDate between :startDate and :endDate")
    List<FlightSearchDto> findDepartureFlightsByAirportBetweenTwoDates(@Param("id") Long id,
                                                                       @Param("startDate") LocalDateTime startDate,
                                                                       @Param("endDate") LocalDateTime endDate);

    @Query("select new ro.cosmin.airports.models.FlightSearchDto(f.id, f.flightNumber, f.departureDate, f.arrivalDate, f.airline, f.departureAirport, f.arrivalAirport) " +
            "from Flight f " +
            "where f.arrivalAirport.id = :id and f.arrivalDate between :startDate and :endDate")
    List<FlightSearchDto> findArrivalFlightsByAirportBetweenTwoDates(@Param("id") Long id,
                                                                     @Param("startDate") LocalDateTime startDate,
                                                                     @Param("endDate") LocalDateTime endDate);

    @Query("select new ro.cosmin.airports.models.FlightSearchDto(f.id, f.flightNumber, f.departureDate, f.arrivalDate, f.airline, f.departureAirport, f.arrivalAirport) " +
            " from Flight f " +
            " where f.airline.id = :id and f.arrivalDate between :startDate and :endDate and f.departureDate between :startDate and :endDate")
    List<FlightSearchDto> findFlightsByAirlineBetweenTwoDates(@Param("id") Long id,
                                                              @Param("startDate") LocalDateTime startDate,
                                                              @Param("endDate") LocalDateTime endDate);
}
