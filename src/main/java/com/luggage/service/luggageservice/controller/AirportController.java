package com.luggage.service.luggageservice.controller;

import com.luggage.service.luggageservice.dataService.AirportServiceImpl;
import com.luggage.service.luggageservice.model.Airport;
import com.luggage.service.luggageservice.exception.AirportNotFoundException;
import com.luggage.service.luggageservice.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/airport")
public class AirportController {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirportServiceImpl airportService;

//get all airports
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List getAll() throws AirportNotFoundException{
        return airportService.findAll();
    }

    //retrieves all airport information by aiprort id.
    @GetMapping(path = "id/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Airport airportId(@PathVariable Integer id) throws AirportNotFoundException {
        return airportService.findAirportById(id);

    }
    //retrieves all airport information by airport name
    @GetMapping(path = "name/{name}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Airport findAirportByName(@PathVariable String name) throws AirportNotFoundException {

        return airportService.findAirportByName(name);

    }

    //retrieves all airport information by city
    @GetMapping(path = "city/{city}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Airport> findAirportByCity(@PathVariable String city) throws AirportNotFoundException {
        return airportService.findAirportByCity(city);

    }

    //retrieves all airport information by country
    @GetMapping(path = "country/{country}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Airport> findAirportByCountry(@PathVariable String country) throws AirportNotFoundException {
        return airportService.findAirportByCountry(country);

    }
    //retrieves all luggage in airport by airport name.
    @GetMapping(path = "luggageInAirport/{name}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Airport> findLuggageInAirportByName(@PathVariable String name) throws AirportNotFoundException{
        return airportService.findAllLuggageByAirportName(name);
    }

    //retrieves luggage by luggage id and by airport name
    @GetMapping(path = "findLuggage/id/{id}/airportName/{name}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Airport> findLuggageInAirportByName(@PathVariable int id,@PathVariable String name) throws AirportNotFoundException{
        return airportService.findAllLuggageByAirportNameAndById(id,name);
    }

}
