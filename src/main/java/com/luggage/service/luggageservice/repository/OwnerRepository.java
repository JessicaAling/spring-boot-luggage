package com.luggage.service.luggageservice.repository;

import com.luggage.service.luggageservice.model.Luggage;
import com.luggage.service.luggageservice.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {


    @Query("Select o from Owner o where o.firstName =:firstName")
    Owner findOwner(String firstName);

    //@Query("SELECT l FROM Luggage l inner join l.owner o where l.id = :id and o.name =:name")
    //List<Luggage> findAllLuggageByAirportNameAndId(int id, String name);
}
