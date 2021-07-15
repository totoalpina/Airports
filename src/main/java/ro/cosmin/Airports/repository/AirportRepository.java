package ro.cosmin.Airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cosmin.Airports.entities.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
