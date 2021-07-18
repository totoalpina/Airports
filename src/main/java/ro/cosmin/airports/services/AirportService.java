package ro.cosmin.airports.services;

import ro.cosmin.airports.models.AirportDto;

import java.util.List;

public interface AirportService {

    List<AirportDto> findAll();

}
