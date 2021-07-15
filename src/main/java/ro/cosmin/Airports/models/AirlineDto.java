package ro.cosmin.Airports.models;

public class AirlineDto {

    private String airlineName;

    private String airlineCode;

    private String airlineCallSign;

    private String airlineCountry;

    public AirlineDto(String airlineName, String airlineCode, String airlineCallSign, String airlineCountry) {
        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
        this.airlineCallSign = airlineCallSign;
        this.airlineCountry = airlineCountry;
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
}
