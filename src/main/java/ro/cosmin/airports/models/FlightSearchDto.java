package ro.cosmin.airports.models;

import ro.cosmin.airports.entities.Airline;
import ro.cosmin.airports.entities.Airport;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


public class FlightSearchDto {

    private Long id;
    @NotEmpty(message = "Flight number must not be empty")
    private String flightNumber;
    @NotEmpty
    private LocalDateTime departureDate;
    @NotEmpty
    private LocalDateTime arrivalDate;

    private Airline airline;

    private Airport departureAirport;

    private Airport arrivalAirport;

    public FlightSearchDto() {
    }

    public FlightSearchDto(String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, Airline airline, Airport departureAirport, Airport arrivalAirport) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public FlightSearchDto(Long id, String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, Airline airline, Airport departureAirport, Airport arrivalAirport) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}
