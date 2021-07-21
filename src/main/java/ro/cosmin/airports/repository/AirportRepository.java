package ro.cosmin.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.cosmin.airports.entities.Airport;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {

//    @Query("select f from Flight f JOIN a.airport f where a.airportName = :airport and f.arrivalDate BETWEEN :start and :end")
//    List<Airport> retrieveFlightsByArrivalAirport(@Param("airport") String airport, @Param("start") String startDate, @Param("end") String endDate);
}
