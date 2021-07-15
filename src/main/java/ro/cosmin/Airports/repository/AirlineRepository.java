package ro.cosmin.Airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cosmin.Airports.entities.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
}
