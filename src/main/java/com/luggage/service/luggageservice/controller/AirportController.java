package com.luggage.service.luggageservice.controller;

import com.luggage.service.luggageservice.dataService.AirportServiceImpl;
import com.luggage.service.luggageservice.entity.Airport;
import com.luggage.service.luggageservice.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/airport")
public class AirportController {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirportServiceImpl airportService;


    @GetMapping(path = "/hello")
    @ResponseBody
    public String sayHello() {
        return "{'Hej'}";
    }

    //funkar
    @GetMapping(path = "/test")
    @ResponseBody
    public Iterable findAll() {
        return airportRepository.findAll();
    }


    //funkar
    //exception
    @GetMapping(path = "/all")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Iterable getAll(){ return airportService.findAllAirports();
        }


    @GetMapping(path = "id/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Airport> airportId (@PathVariable int id) {
        return airportService.findAirportById(id);

    }
    //lowercase
    @GetMapping(path = "name/{name}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Airport> airportName (@PathVariable String name) {
        return airportService.findAirportByName(name);

    }

    //lowercase
    @GetMapping(path = "location/{location}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String airportLocation (@PathVariable String location) {
        return airportService.findAirportByLocation(location);

    }
    @GetMapping(path = "nameByID/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Airport> airportLocation (@PathVariable int id) {
        return airportService.findNameById(id);

    }




    //findbyid
    //findbylocation
    //findbyname




}
