package com.luggage.service.luggageservice.controller;

import com.luggage.service.luggageservice.repository.LuggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/luggage")
public class LuggageController {

    @Autowired
    LuggageRepository luggageRepository;

    @GetMapping
    public Iterable findAll() {
        return luggageRepository.findAll();
    }
    //getAllLuggagge
    //findById
    //findByShelf
    //insertLuggage
    //updateLuggage
    //deleteLugggae


}
