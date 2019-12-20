package com.luggage.service.luggageservice.repository;

import com.luggage.service.luggageservice.model.Airport;
import com.luggage.service.luggageservice.model.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public interface AirportRepository  extends JpaRepository<Airport,Integer> {

  List<Airport> findAll();

    @Query(value = "SELECT a FROM Airport a")
    Optional<Airport> findAllAirport();

    @Query("SELECT a FROM Airport a WHERE a.id = :id")
    Airport findByAirportId(Integer id);

    @Query("SELECT a FROM Airport a WHERE a.name = :name")
    Airport findByName(String name);

    @Query("SELECT NEW com.luggage.service.luggageservice.model.Airport(a.name,a.city,a.country) FROM Airport a WHERE a.city = ?1")
    ArrayList<Airport> findByCity(String city);

    @Query( "SELECT NEW com.luggage.service.luggageservice.model.Airport( a.name,a.city,a.country)  FROM Airport a WHERE a.country = :country")
    List<Airport> findByCountry(@Param("country") String country);

    @Query("SELECT l FROM Luggage l inner join l.airport al where al.name =:name")
    List<Luggage> findAllLuggageByAirportName(String name);

    @Query("SELECT l FROM Luggage l inner join l.airport al where l.id = :id")
    List<Luggage> findAllLuggageByAirportNameAndId(int id);

}
