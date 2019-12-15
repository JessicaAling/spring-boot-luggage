package com.luggage.service.luggageservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="airport")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Airport implements Serializable {

    @Id
    @Column(name="airport_id")
    Integer airportId;

    @NotBlank
    String name;
    @NotBlank
    String city;
    @NotBlank
    String country;

    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private Set<Luggage> luggages;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private IATA iataCode;

    public Airport() {
    }

    public Airport(String name, String city, String country, IATA iataCode) {
        this.name = name;
        this.city=city;
        this.country= country;
        this.iataCode=iataCode;

    }
    public Airport(String name, String city, String country) {
        this.name = name;
        this.city=city;
        this.country= country;


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


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country;
    }

    public IATA getIataCode() {
        return iataCode;
    }

    public void setIataCode(IATA iataCode) {
        this.iataCode = iataCode;
    }

    public Set<Luggage> getLuggages() {
        return luggages;
    }

    public void setLuggages(Set<Luggage> luggages) {
        this.luggages = luggages;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(airport, airport.airportId) &&
                Objects.equals(name, airport.name) &&
                Objects.equals(city, airport.city)&&
                Objects.equals(country, airport.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId, name, city,country);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + airportId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
             //  ", luggage='" + luggage.getLuggageIdId() + '\'' +
                '}';
    }
}
