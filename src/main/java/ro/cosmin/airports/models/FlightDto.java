package ro.cosmin.airports.models;

import org.springframework.format.annotation.DateTimeFormat;
import ro.cosmin.airports.entities.Airline;
import ro.cosmin.airports.entities.Airport;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;

public class FlightDto {

    private Long id;
    @NotEmpty
    private String flightNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date arrivalDate;

    private Airline airline;

    private Airport departureAirport;

    private Airport arrivalAirport;

    public FlightDto() {
    }

    public FlightDto(String flightNumber, Date departureDate, Date arrivalDate, Airline airline, Airport departureAirport, Airport arrivalAirport) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public FlightDto(Long id, String flightNumber, Date departureDate, Date arrivalDate, Airline airline, Airport departureAirport, Airport arrivalAirport) {
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

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
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
