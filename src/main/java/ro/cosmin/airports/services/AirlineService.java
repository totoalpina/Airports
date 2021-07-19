package ro.cosmin.airports.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.cosmin.airports.entities.Airline;
import ro.cosmin.airports.models.AirlineDto;

import java.util.List;

public interface AirlineService{

    List<AirlineDto> findAll();
    Page<Airline> findAll(Pageable pageable);
}
