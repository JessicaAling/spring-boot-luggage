package com.luggage.service.luggageservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {

    @Id
    @Column(name="owner_id")
    private Integer ownerId;
    //@Column(name="")
    private String firstName;
   // @Column(name="owner_id")
    private String lastName;
    //@Column(name="owner_id")
    private String phoneNumber;


    @OneToMany(mappedBy = "luggageOwner", cascade = CascadeType.ALL)
    private Set<Luggage> luggages;

    public Owner() {

    }

    public Owner(String firstName, String lastName, String phoneNumber, Set<Luggage> luggages) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner that = (Owner) o;
        return Objects.equals(ownerId, that.ownerId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(luggages, that.luggages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, firstName, lastName, phoneNumber, luggages);
    }

    @Override
    public String toString() {
        return "LuggageOwner{" +
                " ownerId=" +  ownerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
              //  ", luggages=" + luggages +
                '}';
    }
}
