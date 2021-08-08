package ro.cosmin.airports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.cosmin.airports.entities.Airport;
import ro.cosmin.airports.models.AirportDto;
import ro.cosmin.airports.repository.AirportRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Optional<AirportDto> findById(Long id) {
        return airportRepository.findById(id)
                .map(airport -> new AirportDto(airport.getId(),
                        airport.getAirportName(),
                        airport.getAirportCity(),
                        airport.getAirportCountry(),
                        airport.getAirportCode(),
                        airport.getLatitude(),
                        airport.getLongitude()));
    }

    @Override
    public List<AirportDto> findAll() {
        return airportRepository.findAll()
                .stream()
                .map(a -> new AirportDto(a.getAirportName(),
                        a.getAirportCity(),
                        a.getAirportCountry(),
                        a.getAirportCode(),
                        a.getLatitude(),
                        a.getLongitude()))
                .collect(Collectors.toList());
    }

    @Override
    public Page<Airport> findAll(Pageable pageable) {
        return airportRepository.findAll(pageable);
    }

}
