package models;

import java.util.List;

public class Airplane {
    private Long id;
    private AirplaneCharacteristics characteristics;
    private TemporaryPoint position;
    private List<Flight> flights;

    public Airplane(AirplaneCharacteristics characteristics, TemporaryPoint position) {
        this.characteristics = characteristics;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AirplaneCharacteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(AirplaneCharacteristics characteristics) {
        this.characteristics = characteristics;
    }

    public TemporaryPoint getPosition() {
        return position;
    }

    public void setPosition(TemporaryPoint position) {
        this.position = position;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

}
