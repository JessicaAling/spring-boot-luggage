package com.luggage.service.luggageservice.dataService;


import com.luggage.service.luggageservice.exception.AirportNotFoundException;
import com.luggage.service.luggageservice.exception.LuggageNotFoundException;
import com.luggage.service.luggageservice.exception.OwnerNotFoundException;
import com.luggage.service.luggageservice.model.Airport;
import com.luggage.service.luggageservice.model.Luggage;
import com.luggage.service.luggageservice.model.Owner;
import com.luggage.service.luggageservice.repository.AirportRepository;
import com.luggage.service.luggageservice.repository.LuggageRepository;
import com.luggage.service.luggageservice.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Transactional
@Service
public class LuggageServiceImpl {

    private LuggageRepository luggageRepository;

    private AirportRepository airportRepository;

    private OwnerRepository ownerRepository;

    private OwnerServiceImpl ownerService;

    public LuggageServiceImpl(LuggageRepository luggageRepository, AirportRepository airportRepository, OwnerRepository ownerRepository, OwnerServiceImpl ownerService) {
        this.luggageRepository = luggageRepository;
        this.airportRepository = airportRepository;
        this.ownerRepository = ownerRepository;
        this.ownerService = ownerService;
    }

    public List<Luggage> findAllLuggage() {
        List<Luggage> luggages = luggageRepository.findAll();
        return luggages;
    }

    public Optional<Luggage> findLuggageById(Integer id) {
        Optional<Luggage> luggageId = luggageRepository.findLuggageById(id);
        return luggageId;
    }

    public Optional<Luggage> findLuggageByShelf(String shelf) {
        Optional<Luggage> luggageShelf = luggageRepository.findByShelf(shelf);
        return luggageShelf;
    }

    public Optional<Luggage> findAirportByLuggageId(Integer id) {
        Optional<Luggage> luggageId = luggageRepository.findLuggageByAirport(id);
        return luggageId;
    }

    public Luggage insertNewLuggage(Integer airportId, Integer ownerId, Luggage luggage) {
        luggage.setLuggageOwner(luggage.getLuggageOwner());
        Owner owner = ownerRepository.getOne(ownerId);

        if (owner == null || owner.equals(" ")) {
            throw new OwnerNotFoundException("No owner found for this id");
        }
        owner.addLuggage(luggage);
        try {
            ownerRepository.saveAndFlush(owner);
        } catch (Exception e) {
            throw new OwnerNotFoundException("Luggage with owner could not be saved", e);
        }

        Airport airport = airportRepository.findByAirportId(airportId);
        if (airport == null || airport.equals(" ")) {
            throw new AirportNotFoundException("No airport found for this id");
        }
        airport.addLuggage(luggage);
        airportRepository.save(airport);

        luggage.setAirports(airport);
        luggage.setLuggageOwner(owner);


        try {
            luggageRepository.saveAndFlush(luggage);
            return luggage;
        } catch (Exception e) {
            throw new LuggageNotFoundException("Error: luggage was not saved", e.getCause());
        }

    }

    public Luggage removeLuggage(Luggage luggage) {
        Luggage luggageRemove = luggageRepository.getOne(luggage.getLuggageId());
        luggageRepository.delete(luggageRemove);
        return luggageRemove;
    }

    public Luggage updateLuggage(Integer luggageId, Luggage luggage) {
        Luggage updateLuggage = luggageRepository.findLuggageId(luggageId);
        updateLuggage.setShelf(luggage.getShelf());
        updateLuggage = luggageRepository.save(updateLuggage);
        return updateLuggage;
    }

}



