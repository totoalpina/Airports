package ro.cosmin.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cosmin.airports.domain.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
}
