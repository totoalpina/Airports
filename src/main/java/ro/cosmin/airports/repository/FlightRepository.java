package ro.cosmin.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.cosmin.airports.entities.Flight;

import java.sql.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("select f from Flight f where f.arrivalAirport.airportName = :airport and f.arrivalDate between :startDate and :endDate")
    List<Flight> retrieveFlightsByAirportAndByDate(@Param("airport") String airport, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
