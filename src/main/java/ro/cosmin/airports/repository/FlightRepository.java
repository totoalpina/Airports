package ro.cosmin.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cosmin.airports.domain.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
