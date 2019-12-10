package com.luggage.service.luggageservice.repository;

import com.luggage.service.luggageservice.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AirportRepository  extends JpaRepository<Airport,Integer> {

    public List<Airport> findAll();

    Airport findByNameContainingIgnoreCase(String name);

    @Query(value = "SELECT a FROM Airport a")
    Optional<Airport> findAllAirport();

    @Query("SELECT a FROM Airport a WHERE a.id = :id")
    Airport findByAirportId(Integer id);

    @Query("SELECT u FROM Airport u WHERE u.name = :name")
    Airport findByName(String name);

    @Query("SELECT a.id,a.name FROM  Airport a where a.id = :id")
    Optional<Airport> findNameById(@Param("id") Integer id);

    @Query("SELECT a FROM Airport a WHERE a.city = ?1")
    Optional<Airport>  findByCity(String city);


    Optional<Airport>  findByCityContainingIgnoreCase(String city);


    @Query(value="SELECT a.airport_id, a.name, a.city, a.country, a.iata_code FROM Airport a WHERE a.country = :country", nativeQuery=true)
    List<Airport> findByCountry(@Param("country")String country);

    List<Airport> findByCountryContainingIgnoreCase(String country);


  /*  @Query("SELECT a.airportId, a.country, a.city FROM Airport a WHERE a.country = ?1")
    Airport findByCountry(String country);*/


}
