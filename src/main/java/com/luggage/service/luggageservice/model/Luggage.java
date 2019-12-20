package com.luggage.service.luggageservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
//@Table(name = "luggage")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Luggage {

    @Id
    @Column(name="luggage_id")
    private Integer luggageId;

    @NotBlank(message = "shelf can not be empty")
    private String shelf;

    // private String dateAndTime;

    private String comment;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_airport_id")
    @JsonIgnore
    private Airport airport;

    @ManyToOne(fetch=FetchType.LAZY )
    @JoinColumn(name="fk_owner_id")
    @JsonIgnore
    private Owner luggageOwner;

    //hibernate
    public Luggage() {
    }

    public Luggage(String shelf, String comment, Airport airport, Owner luggageOwner) {
        this.shelf = shelf;
        this.comment = comment;
        this.airport=airport;
        this.luggageOwner=luggageOwner;
    }

    public Integer getLuggageId() {
        return luggageId;
    }

    public void setLuggageId(Integer luggageId) {
        this.luggageId= luggageId;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Luggage luggage = (Luggage) o;
        return luggageId == luggage.luggageId &&
                Objects.equals(shelf, luggage.shelf) &&
                Objects.equals(comment, luggage.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(luggageId, shelf, comment);
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirports(Airport airport) {
        this.airport = airport;
    }

    public Owner getLuggageOwner() {
        return luggageOwner;
    }

    public void setLuggageOwner(Owner luggageOwner) {
        this.luggageOwner = luggageOwner;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "id=" + luggageId +
                ", shelf='" + shelf + '\'' +
                ", comment='" + comment + '\'' +
                ", airport='" + airport.getName() + '\'' +
                '}';
    }
}
