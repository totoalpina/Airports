package ro.cosmin.Airports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.cosmin.Airports.domain.Airline;
import ro.cosmin.Airports.domain.Airport;
import ro.cosmin.Airports.models.AirlineDto;
import ro.cosmin.Airports.models.AirportDto;
import ro.cosmin.Airports.repository.AirlineRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineServiceImpl implements AirlineService{

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<AirlineDto> findAll() {
        return airlineRepository.findAll()
                .stream()
                .map(airline -> new AirlineDto(airline.getAirlineName(),
                        airline.getAirlineCode(),
                        airline.getAirlineCallSign(),
                        airline.getAirlineCountry()))
                .collect(Collectors.toList());
    }

    @Override
    public Page<Airline> findAll(Pageable pageable) {
        Page<Airline> airlinePage = airlineRepository.findAll(pageable);
        return airlinePage;
    }
}
