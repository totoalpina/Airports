package ro.cosmin.airports.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;

@Entity
@Table(name = "flights", uniqueConstraints = {
        @UniqueConstraint(name = "unique_flight_no", columnNames = {"flight_no"})
})
public class Flight {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(name = "flight_no")
    private String flightNumber;

    @Column(name = "departure")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureDate;

    @Column(name = "arrival")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date arrivalDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    public Flight() {
    }

    public Flight(Long id, String flightNumber, Date departureDate, Date arrivalDate, Airline airline, Airport departureAirport, Airport arrivalAirport) {
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
