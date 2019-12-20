package com.luggage.service.luggageservice.controller;

import com.luggage.service.luggageservice.dataService.OwnerServiceImpl;
import com.luggage.service.luggageservice.model.Luggage;
import com.luggage.service.luggageservice.model.Owner;
import com.luggage.service.luggageservice.repository.LuggageRepository;
import com.luggage.service.luggageservice.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerServiceImpl ownerService;

    @Autowired
    private LuggageRepository repository;

    // get owner by id
    @GetMapping(path = "id/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Owner> getOwnerById(@PathVariable Integer id) {
        return ownerRepository.findById(id);
    }

    //get owner by name
    @GetMapping(path = "name/{firstName}/surname/{surName}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Owner getOwnerByName(@PathVariable String firstName,@PathVariable String surName) {
        return ownerService.findOwner(firstName, surName);

    }

    //post owner
    @PostMapping(path = "/insert/owner", consumes = "application/json", produces = "application/json")
    public @Valid Owner insertNewOwner(@Valid @RequestBody Owner owner) {
        return ownerService.saveNewOwner(owner);

    }


    //put
    @PutMapping(path = "/update/owner", consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody
    Owner updateOwner(@RequestBody Owner owner) {
        return ownerService.updateOwnerInformation(owner);

    }

    //delete owner with luggages
    @DeleteMapping(path = "/delete/owner", consumes = "application/json", produces = "application/json")
    public @ResponseBody Owner deleteOwner(@RequestBody Owner owner) {
      return  ownerService.deleteOwnerInformation(owner);
    }



}
