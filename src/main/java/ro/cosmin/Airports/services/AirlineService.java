package ro.cosmin.Airports.services;

import ro.cosmin.Airports.models.AirlineDto;

import java.util.List;

public interface AirlineService{

    List<AirlineDto> findAll();
}
