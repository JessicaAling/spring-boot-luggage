package com.luggage.service.luggageservice.controller;

import com.luggage.service.luggageservice.dataService.LuggageServiceImpl;
import com.luggage.service.luggageservice.entity.Luggage;
import com.luggage.service.luggageservice.repository.LuggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/luggage")
public class LuggageController {

    @Autowired
    LuggageRepository luggageRepository;


    @Autowired
    LuggageServiceImpl luggageService;

    @GetMapping(path = "/testar")
    @ResponseBody
    public List<Luggage> findAll() {

        return luggageRepository.findAll();

    }

    @GetMapping(path = "/all")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Iterable getAll() {

        return luggageService.findAllLuggage();

    }

    @GetMapping(path = "id/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Luggage> luggageId(@PathVariable Integer id) {

        return luggageService.findLuggageById(id);

    }

    @GetMapping(path = "shelf/{shelf}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Luggage> luggageShelf(@PathVariable String shelf) {

        return luggageService.findLuggageByShelf(shelf);

    }

   @GetMapping(path = "comment/{comment}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Luggage> luggageComment(@PathVariable String comment) {
        return luggageService.findLuggageByComment(comment);

    }

    @GetMapping(path = "luggage/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Luggage> luggageAirport(@PathVariable String id) {

        return luggageService.findLuggageByAirport(id);

    }

    //getAllLuggagge
    //findById
    //findLuggageByShelf
    //insertLuggage
    //updateLuggage
    //deleteLugggae

    //find luggage by airport


}
