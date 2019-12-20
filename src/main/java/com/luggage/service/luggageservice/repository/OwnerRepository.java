package com.luggage.service.luggageservice.repository;

import com.luggage.service.luggageservice.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {


    @Query("Select o from Owner o where o.firstName =:firstName and o.surName =:surName ")
    Owner findOwner(String firstName,String surName);

    //@Query("SELECT l FROM Luggage l inner join l.owner o where l.id = :id and o.name =:name")
    //List<Luggage> findAllLuggageByAirportNameAndId(int id, String name);
}
