package com.luggage.service.luggageservice.controller;

import com.luggage.service.luggageservice.dataService.LuggageServiceImpl;
import com.luggage.service.luggageservice.model.Luggage;
import com.luggage.service.luggageservice.repository.AirportRepository;
import com.luggage.service.luggageservice.repository.LuggageRepository;
import com.luggage.service.luggageservice.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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

    @Autowired
    private OwnerRepository ownerRepository;

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

    //insert luggage with airport id and owner id
    @PostMapping(path = "/insertLuggage/{airportId}/{ownerId}/luggage", consumes = "application/json", produces = "application/json")
    public Luggage createLuggage(@PathVariable(value = "airportId") Integer airportId,
                                 @PathVariable(value = "ownerId") Integer ownerId,
                                 @Valid @RequestBody Luggage luggage) {
        return luggageService.insertNewLuggage(airportId,ownerId, luggage);
        //return luggageRepository.saveAndFlush(luggage);

    }

    //find luggage and witch airport by luggage id
    @GetMapping(path = "findLuggage/luggageId/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Luggage> findLuggageInAirportByLuggageId(@PathVariable Integer id) {
        return luggageService.findAirportByLuggageId(id);

    }

    @PutMapping(path = "/update/luggage/update/{LuggageId}")
    public @ResponseBody
    Luggage updateLuggage( @RequestBody Luggage luggage, @PathVariable Integer LuggageId) {
        return luggageService.updateLuggage(LuggageId,luggage);    }


    @DeleteMapping(path = "/remove/luggage")
    public @ResponseBody
    Luggage removeLuggage(@RequestBody Luggage luggage) {
        return  luggageService.removeLuggage(luggage);
    }

    //insert luggage with airport id and owner id , but save owner if not exist
    @PostMapping(path = "/insert/{airportId}/luggage", consumes = "application/json", produces = "application/json")
    public Luggage createLuggageAndOwner(@PathVariable(value = "airportId") Integer airportId,
                                         @Valid @RequestBody Luggage luggage) {
        return luggageService.insertNew(airportId,luggage);

    }
}


