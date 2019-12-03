package com.luggage.service.luggageservice.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="airport_id")
    Integer airportId;

    @NotBlank
    String name;
    @NotBlank
    String location;



    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private Set<Luggage> luggages;

    public Airport() {
    }

    public Airport(Integer airportId ,String name, String location) {
        this.airportId = airportId;
        this.name = name;
        this.location = location;

    }


    public Integer getAirportId() { return airportId; }

    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(airport, airport.airportId) &&
                Objects.equals(name, airport.name) &&
                Objects.equals(location, airport.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId, name, location);
    }

    public Set<Luggage> getLuggages() {
        return luggages;
    }

    public void setLuggages(Set<Luggage> luggages) {
        this.luggages = luggages;
    }


    @Override
    public String toString() {
        return "Airport{" +
                "id=" + airportId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
             //  ", luggage='" + luggage.getLuggageIdId() + '\'' +
                '}';
    }
}
