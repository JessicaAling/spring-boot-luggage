package com.luggage.service.luggageservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
//@Table(name = "luggage")
public class Luggage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "", sequenceName = "cr_id_sequence", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crIdSequence")
    @Column(name="luggage_id")
    private Integer luggageId;
    //ev ett till id?
    @NotBlank
    private String shelf;
    //eventuellt
    //String date;
   // private String dateAndTime;

    //kan vara tom
    private String comment;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_airport_id")
    private Airport airport;

    //hibernate
    public Luggage() {
    }

    public Luggage(String shelf, String comment, Airport airport) {
        //this.id = id;
        this.shelf = shelf;
        //this.dateAndTime = dateAndTime;
        this.comment = comment;
        this.airport=airport;
    }

    public Integer getLuggageIdId() {
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

   /*public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }*/

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
