package ro.cosmin.airports.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.cosmin.airports.entities.Airport;
import ro.cosmin.airports.models.AirportDto;

import java.util.List;

public interface AirportService {

    List<AirportDto> findAll();

    Page<Airport> findAll(Pageable pageable);
}
