package com.luggage.service.luggageservice.controller;

import com.luggage.service.luggageservice.dataService.OwnerServiceImpl;
import com.luggage.service.luggageservice.model.Owner;
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
    OwnerRepository ownerRepository;

    @Autowired
    OwnerServiceImpl ownerService;

    // get owner by id
    @GetMapping(path = "id/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Owner> getLuggageById(@PathVariable Integer id) {
        return ownerRepository.findById(id);

    }

    //get owner by name
    @GetMapping(path = "name/{firstName}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Owner getOwner(@PathVariable String firstName) {

        return ownerService.findOwner(firstName);

    }

    //post owner
    @PostMapping(path = "/insert/owner", consumes = "application/json", produces = "application/json")
    public @Valid Owner insertNewOwner(@Valid @RequestBody Owner owner) {
        return ownerRepository.saveAndFlush(owner);
    }

    //put
    @PutMapping(path = "/update/owner", consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Owner updateOwner(@RequestBody Owner owner) {
        return ownerService.updateOwnerInformation(owner);

    }

    //delete
    @DeleteMapping(path = "/delete/owner", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    Owner deleteOwner(@RequestBody Owner owner) {
      return  ownerService.deleteOwnerInformation(owner);
    }


    //join
   /* @GetMapping(path = "find/{firstName}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Owner getOwnerLuggage(@PathVariable String firstName) {

        return ownerService.findOwnerLuggage(firstName);

    }*/

}
