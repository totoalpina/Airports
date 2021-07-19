package ro.cosmin.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cosmin.airports.entities.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
