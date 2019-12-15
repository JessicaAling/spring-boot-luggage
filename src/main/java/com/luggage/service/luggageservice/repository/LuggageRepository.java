package com.luggage.service.luggageservice.repository;

import com.luggage.service.luggageservice.model.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LuggageRepository extends JpaRepository<Luggage, Integer> {

     List<Luggage> findAll();

 @Query("SELECT u FROM Luggage u WHERE u.shelf = :shelf")
 Optional<Luggage> findByShelf(String shelf);

 @Query("SELECT a FROM  Luggage a where a.luggageId = :id")
 Optional<Luggage> findLuggageById(@Param("id") Integer id);

 @Query("SELECT a FROM  Luggage a where a.luggageId = :id")
 Luggage findLuggageId(@Param("id") Integer id);

 @Query("SELECT a.airport FROM  Luggage a where a.airport = :airport")
 Optional<Luggage> findByAirport(String airport);

 //search på id visar vilken flygplats som har vilket bagage
 @Query("SELECT l FROM Airport l inner join l.luggages al where al.id =:id")
 Optional<Luggage> findLuggageByAirport(@Param("id") Integer id);

//eventuellt söka på airport name men den finns i airport


    }
