package com.luggage.service.luggageservice.controller;

import com.luggage.service.luggageservice.dataService.AirportServiceImpl;
import com.luggage.service.luggageservice.entity.Airport;
import com.luggage.service.luggageservice.exception.AirportNotFoundException;
import com.luggage.service.luggageservice.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airport")
public class AirportController {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirportServiceImpl airportService;

    //test
    @GetMapping("/id/id/{id}")
    public ResponseEntity<Airport> read(@PathVariable("id") Integer id) {
        Airport airport = airportRepository.findByAirportId(id);
        if (airport == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(airport);
        }
    }

    //fixa
    // @GetMapping(path = "/all")
    //@ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    //@ResponseStatus(HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List getAll() throws AirportNotFoundException{
        return airportService.findAll();
    }

    @GetMapping(path = "/allAirports")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Airport> getAllAirports() throws AirportNotFoundException {
        return airportService.findAllAirports();
    }


    @GetMapping(path = "id/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Airport airportId(@PathVariable Integer id) {
        if (id == null || id.equals(0)) {

            throw new AirportNotFoundException();
        }

        return airportService.findAirportById(id);

    }

    //lowercase
    @GetMapping(path = "name/{name}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Airport airportName(@PathVariable String name) throws AirportNotFoundException {
        name.equalsIgnoreCase("name");

        String test = "tet";
        test.equalsIgnoreCase("tet");

        return airportService.findAirportByName(name);

    }

    //lowercase
    @GetMapping(path = "city/{city}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Airport> airportCity(@PathVariable String city) throws AirportNotFoundException {
        return airportService.findAirportByCity(city);

    }

    @GetMapping(path = "country/{country}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Airport> airportCountry(@PathVariable String country) throws AirportNotFoundException {
        return airportService.findAirportByCountry(country);

    }

    @GetMapping(path = "nameById/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Airport> getAirportNameById(@PathVariable int id) throws AirportNotFoundException {
        return airportService.findNameById(id);

    }


}
