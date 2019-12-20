package com.luggage.service.luggageservice.dataService;


import com.luggage.service.luggageservice.model.Airport;
import com.luggage.service.luggageservice.exception.AirportNotFoundException;
import com.luggage.service.luggageservice.model.Luggage;
import com.luggage.service.luggageservice.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl {

    private AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List findAll() {
        List<Airport> airport = airportRepository.findAll();
        if (airport.isEmpty() || airport == null) {
            throw new AirportNotFoundException();
        }
        return airport;
    }

    public Airport findAirportById(Integer id) throws AirportNotFoundException {
        Airport airportId = airportRepository.findByAirportId(id);
        if (airportId == null || airportId.equals(" ")) {
            throw new AirportNotFoundException();
        }
        return airportId;
    }

    public Airport findAirportByName(String name) throws AirportNotFoundException {

        Airport airportName = airportRepository.findByName(name);
        if (airportName == null || airportName.equals(" ")) {
            throw new AirportNotFoundException("airport name dosent exist");
        }
        return airportName;
    }


    public List<Airport> findAirportByCity(String city) throws AirportNotFoundException {

        List<Airport> airportCity = airportRepository.findByCity(city);

        if (airportCity.isEmpty() || airportCity.equals("null")) {
            throw new AirportNotFoundException();
        }
        return airportCity;
    }

    public List<Airport> findAirportByCountry(String country) throws AirportNotFoundException {

        List<Airport> airportCountry = airportRepository.findByCountry(country);
        if (airportCountry.isEmpty() || airportCountry.equals("null")) {
            throw new AirportNotFoundException("No airportfound in this country" + country);
        }
        return airportCountry;
    }

    public List findAllLuggageByAirportName(String name) throws AirportNotFoundException {

        List<Luggage> luggage = airportRepository.findAllLuggageByAirportName(name);
        if (luggage.isEmpty() || luggage.equals("null")) {
            throw new AirportNotFoundException("No airportfound in this country" + name);
        }
        return luggage;
    }

    public List findAllLuggageByAirportNameAndById(int id) throws AirportNotFoundException {

        List<Luggage> luggage = airportRepository.findAllLuggageByAirportNameAndId(id);

        if (luggage.isEmpty() || luggage.equals("null")) {
            throw new AirportNotFoundException("No airportfound in this country");
        }
        return luggage;
    }

}
