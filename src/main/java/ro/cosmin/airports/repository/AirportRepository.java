package ro.cosmin.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cosmin.airports.entities.Airport;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    Optional<Airport> findById(Long id);
}
