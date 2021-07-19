package ro.cosmin.Airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cosmin.Airports.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
