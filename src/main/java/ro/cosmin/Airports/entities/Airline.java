package ro.cosmin.Airports.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "airlines")
public class Airline {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(name = "airline_name", length = 100, nullable = false)
    private String airlineName;

    @Column(name = "airline_code", length = 4, nullable = false)
    private String airlineCode;

    @Column(name = "airline_call_sign", length = 25, nullable = false)
    private String airlineCallSign;

    @Column(name = "airline_country", nullable = false)
    private String airlineCountry;

    @OneToMany(mappedBy = "airline")
    private Set<Flight> flightSet;

    public Airline() {

    }

    public Airline(Long id, String airlineName, String airlineCode, String airlineCallSign, String airlineCountry) {
        this.id = id;
        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
        this.airlineCallSign = airlineCallSign;
        this.airlineCountry = airlineCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineCallSign() {
        return airlineCallSign;
    }

    public void setAirlineCallSign(String airlineCallSign) {
        this.airlineCallSign = airlineCallSign;
    }

    public String getAirlineCountry() {
        return airlineCountry;
    }

    public void setAirlineCountry(String airlineCountry) {
        this.airlineCountry = airlineCountry;
    }

    public Set<Flight> getFlightSet() {
        return flightSet;
    }

    public void setFlightSet(Set<Flight> flightSet) {
        this.flightSet = flightSet;
    }
}
