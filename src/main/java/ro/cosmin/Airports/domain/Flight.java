package ro.cosmin.Airports.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(name = "flight_no")
    private String flightNumber;

    @Column(name = "departure")
    private Date departureDate;

    @Column(name = "arrival")
    private Date arrivalDate;


    @Column(name = "departure_airport_id")
    private Long departureAirportID;

    @Column(name = "arrival_airport_id")
    private Long arrivalAirportID;

    @Column(name = "airline_id")
    private Long airlineID;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id")
    private Airline airline;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id")
    private Airport airport;


    public Flight(Long id, String flightNumber,
                  Date departureDate, Date arrivalDate,
                  Long departureAirportID, Long arrivalAirportID,
                  Long airlineID, final Airport departureAirport,
                  final Airport arrivalAirport, final Airport airline) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureAirportID = departureAirport.getId();
        this.arrivalAirportID = arrivalAirport.getId();
        this.airlineID = airline.getId();
    }
}
