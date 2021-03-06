package ro.cosmin.airports.models;

import ro.cosmin.airports.entities.Airline;
import ro.cosmin.airports.entities.Airport;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class FlightDto {

    private Long id;
    @NotEmpty(message = "Flight number must not be empty")
    private String flightNumber;
    @NotEmpty
    private String departureDate;
    @NotEmpty
    private String arrivalDate;

    private Airline airline;

    private Airport departureAirport;

    private Airport arrivalAirport;

    public FlightDto() {
    }

    public FlightDto(String flightNumber, String departureDate, String arrivalDate, Airline airline, Airport departureAirport, Airport arrivalAirport) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public FlightDto(Long id, String flightNumber, String departureDate, String arrivalDate, Airline airline, Airport departureAirport, Airport arrivalAirport) {
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

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return Objects.equals(id, flightDto.id) && flightNumber.equals(flightDto.flightNumber) && departureDate.equals(flightDto.departureDate) && arrivalDate.equals(flightDto.arrivalDate) && Objects.equals(airline, flightDto.airline) && Objects.equals(departureAirport, flightDto.departureAirport) && Objects.equals(arrivalAirport, flightDto.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNumber, departureDate, arrivalDate, airline, departureAirport, arrivalAirport);
    }



}

