package ro.cosmin.Airports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cosmin.Airports.models.AirportDto;
import ro.cosmin.Airports.repository.AirportRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService{

    @Autowired
    private AirportRepository airportRepository;

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
}
