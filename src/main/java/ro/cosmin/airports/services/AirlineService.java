package ro.cosmin.airports.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.cosmin.airports.entities.Airline;
import ro.cosmin.airports.models.AirlineDto;

import java.util.List;
import java.util.Optional;

public interface AirlineService {

    List<AirlineDto> findAll();

    Page<Airline> findAll(Pageable pageable);

    Optional<AirlineDto> findById(Long id);
}
