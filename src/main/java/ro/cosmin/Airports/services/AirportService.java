package ro.cosmin.Airports.services;

import org.springframework.stereotype.Service;
import ro.cosmin.Airports.models.AirportDto;

import java.util.List;


public interface AirportService {

    List<AirportDto> findAll();

}
