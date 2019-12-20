package com.luggage.service.luggageservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {

    @Id
    @Column(name="owner_id")
    private Integer ownerId;

    @NotBlank(message = "Name can not be empty")
    private String firstName;

    @NotBlank(message = "Surname can not be empty")
    private String surName;

    @NotBlank(message = "phone number can not be empty")
    private String phoneNumber;

    @OneToMany(mappedBy = "luggageOwner", cascade = CascadeType.ALL)
    private Set<Luggage> luggages;

    public Owner() {

    }

    public Owner(String firstName, String surName, String phoneNumber, Set<Luggage> luggages) {
        this.firstName = firstName;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.luggages = luggages;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer  ownerId) {
        this. ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String lastName) {
        this.surName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Luggage> getLuggages() {
        return luggages;
    }

    public void setLuggages(Set<Luggage> luggages) {
        this.luggages = luggages;
    }

    public void addLuggage(Luggage luggage) {
        luggages.add(luggage);
        luggage.setLuggageOwner(this);
    }

    public void removeLuggage(Luggage luggage) {
        luggages.remove(luggage);
        luggage.setLuggageOwner(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner that = (Owner) o;
        return Objects.equals(ownerId, that.ownerId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(surName, that.surName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(luggages, that.luggages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, firstName, surName, phoneNumber, luggages);
    }

    @Override
    public String toString() {
        return "LuggageOwner{" +
                " ownerId=" +  ownerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + surName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
              //  ", luggages=" + luggages +
                '}';
    }
}
