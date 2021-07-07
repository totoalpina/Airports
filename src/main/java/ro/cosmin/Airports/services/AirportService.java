package ro.cosmin.Airports.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.cosmin.Airports.domain.Airport;
import ro.cosmin.Airports.models.AirportDto;

import java.util.List;

public interface AirportService {

    List<AirportDto> findAll();

    Page<Airport> findAll(Pageable pageable);

}
