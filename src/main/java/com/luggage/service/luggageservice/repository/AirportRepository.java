package com.luggage.service.luggageservice.repository;

import com.luggage.service.luggageservice.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AirportRepository  extends JpaRepository<Airport,Integer> {

    public List<Airport> findAll();

   // @Query("SELECT u FROM Airport u WHERE u.name = :")
    //String  findAirportName(@Param("name") String name);

    @Query("SELECT u.name FROM Airport u WHERE u.name = :name")
    Optional<Airport> findByName(String name);

    @Query("SELECT u.location FROM Airport u WHERE u.location = :location")
    String findByLocation(String location);

    @Query("SELECT a.name FROM  Airport a where a.id = :id")
    Optional<Airport>  findNameById(@Param("id") int id);
}
