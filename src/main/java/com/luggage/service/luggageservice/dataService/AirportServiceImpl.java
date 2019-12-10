package com.luggage.service.luggageservice.dataService;


import com.luggage.service.luggageservice.entity.Airport;
import com.luggage.service.luggageservice.exception.AirportNotFoundException;
import com.luggage.service.luggageservice.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirportServiceImpl {

    private AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }


    //byta metod namn
    public Optional<Airport> findAllAirports() {
        Optional<Airport> airports;
        try {
            airports = airportRepository.findAllAirport();
        } catch (AirportNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
        return airports;
    }
    public List findAll() {
        List <Airport> airport = airportRepository.findAll();
        return airport;
    }

   /* public List<Airport> findAllAirports() {
        List<Airport> airports = airportRepository.findAllAirport();
        return airports;
    }*/

    public Airport findAirportById(Integer id) {


        Airport airportId = airportRepository.findByAirportId(id);

        if (airportId.getAirportId() == null) {
            throw new AirportNotFoundException();
        }
        return airportId;


    }

    public Airport findAirportByName(String name) {
        Airport airportName = airportRepository.findByNameContainingIgnoreCase(name);
        if (airportName == null) {
            throw new AirportNotFoundException();
        }
        return airportName;

    }

    public Optional<Airport> findNameById(Integer id) {
        Optional<Airport> airportName = Optional.ofNullable(airportRepository.findNameById(id).orElseThrow(AirportNotFoundException::new));

        //if (airportName == null) {
          //  throw new AirportNotFoundException("Airport id dosent exist");
        //}
        return airportName;
    }

    public Optional<Airport> findAirportByCity(String city) {

        try {
            Optional<Airport> airportCity = airportRepository.findByCityContainingIgnoreCase(city);
            return airportCity;
        } catch (NullPointerException e) {
            throw new AirportNotFoundException(e.getMessage());
        }


    }

    public List<Airport> findAirportByCountry(String country) {

        List<Airport> airportCountry = airportRepository.findByCountryContainingIgnoreCase(country);
                //findByCountry(country);
        if (airportCountry == null) {
            throw new AirportNotFoundException("No airportfound in this country" + country);
        }
        return airportCountry;
    }



}
