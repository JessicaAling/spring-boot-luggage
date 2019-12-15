package com.luggage.service.luggageservice.controller;

import com.luggage.service.luggageservice.dataService.LuggageServiceImpl;
import com.luggage.service.luggageservice.model.Luggage;
import com.luggage.service.luggageservice.exception.AirportNotFoundException;
import com.luggage.service.luggageservice.repository.AirportRepository;
import com.luggage.service.luggageservice.repository.LuggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/luggage")
public class LuggageController {

    @Autowired
    private LuggageRepository luggageRepository;

    @Autowired
    private LuggageServiceImpl luggageService;

    @Autowired
    private AirportRepository airportRepository;

    //get all luggage
    @GetMapping(path = "/allLuggage")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Iterable getAll() {
        return luggageService.findAllLuggage();

    }

    //find luggage by id
    @GetMapping(path = "findLuggage/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Luggage> getLuggageById(@PathVariable Integer id) {

        return luggageService.findLuggageById(id);

    }

    //find luggage by shelf
    @GetMapping(path = "shelf/{shelf}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Luggage> luggageShelf(@PathVariable String shelf) {
        return luggageService.findLuggageByShelf(shelf);

    }

    @PostMapping(path="/l/{airportId}/luggage",consumes = "application/json", produces = "application/json")
    public ResponseEntity<Luggage> insertNewLuggage(@PathVariable(value = "airportId") Integer airportId,
                                                   @Valid @RequestBody Luggage luggage)
    {
        Luggage luggage1 = luggageService.insertLuggage(airportId,luggage);
        return ResponseEntity.ok(luggage1);
    }
    @PostMapping(path="/insertLuggage/{airportId}/luggage",consumes = "application/json", produces = "application/json")
    public Luggage createLuggage(@PathVariable (value = "airportId") Integer airportId,
                                 @Valid @RequestBody Luggage luggage) {
        return airportRepository.findById(airportId).map(a -> {
            luggage.setAirports(a);
            luggage.setLuggageId(luggage.getLuggageId());
            return luggageRepository.saveAndFlush(luggage);
        }).orElseThrow(()-> new AirportNotFoundException());

    }
    //find luggage by luggage id and then show
    @GetMapping(path = "findLuggage/airportId/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Luggage> findLuggageByAirportId(@PathVariable Integer id) {
        return luggageService.findAirportByLuggageById(id);

    }

}
