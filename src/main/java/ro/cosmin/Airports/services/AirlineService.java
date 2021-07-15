package ro.cosmin.Airports.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.cosmin.Airports.entities.Airline;
import ro.cosmin.Airports.models.AirlineDto;

import java.util.List;

public interface AirlineService{

    List<AirlineDto> findAll();
    Page<Airline> findAll(Pageable pageable);
}
