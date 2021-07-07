package ro.cosmin.Airports.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(name = "airport_name", nullable = false)
    private String airportName;

    @Column(name = "airport_city", nullable = false)
    private String airportCity;

    @Column(name = "airport_country", nullable = false)
    private String airportCountry;

    @Column(name = "airport_code", length = 4, nullable = false)
    private String airportCode;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @OneToMany(mappedBy = "departure_airport", fetch = FetchType.LAZY
            , cascade = CascadeType.ALL)
    private Set<Flight> departure_flights;

    @OneToMany(mappedBy = "arrival_airport", fetch = FetchType.LAZY
            , cascade = CascadeType.ALL)
    private Set<Flight> arrival_flights;
    public Airport() {

    }

    public Airport(Long id, String airportName, String airportCity, String airportCountry, String airportCode, String latitude, String longitude) {
        this.id = id;
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCountry = airportCountry;
        this.airportCode = airportCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Set<Flight> getDeparture_flights() {
        return departure_flights;
    }

    public void setDeparture_flights(Set<Flight> departure_flights) {
        this.departure_flights = departure_flights;
    }

    public Set<Flight> getArrival_flights() {
        return arrival_flights;
    }

    public void setArrival_flights(Set<Flight> arrival_flights) {
        this.arrival_flights = arrival_flights;
    }
}
