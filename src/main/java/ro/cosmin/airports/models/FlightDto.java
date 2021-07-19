package ro.cosmin.airports.models;

import javax.validation.constraints.NotEmpty;
import ro.cosmin.airports.entities.Airline;
import ro.cosmin.airports.entities.Airport;

import java.time.Instant;

public class FlightDto {

    @NotEmpty(message = "Flight number must not be empty")
    private String flightNumber;
    @NotEmpty
    private Instant departureDate;
    @NotEmpty
    private Instant arrivalDate;
    @NotEmpty
    private Airline airline;
    @NotEmpty
    private Airport departureAirport;
    @NotEmpty
    private Airport arrivalAirport;

    public FlightDto() {
    }

    public FlightDto(String flightNumber, Instant departureDate, Instant arrivalDate, Airline airline, Airport departureAirport, Airport arrivalAirport) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public FlightDto(Long id, String flightNumber, Instant departureDate, Instant arrivalDate, Airline airline, Airport departureAirport, Airport arrivalAirport) {
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

    public Instant getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Instant departureDate) {
        this.departureDate = departureDate;
    }

    public Instant getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Instant arrivalDate) {
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
