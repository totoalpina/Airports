package ro.cosmin.airports.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.cosmin.airports.entities.Airport;
import ro.cosmin.airports.models.AirportDto;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    List<AirportDto> findAll();

    Optional<AirportDto> findById(Long id);

    Page<Airport> findAll(Pageable pageable);

}
