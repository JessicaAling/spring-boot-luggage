package com.luggage.service.luggageservice.dataService;


import com.luggage.service.luggageservice.model.Airport;
import com.luggage.service.luggageservice.model.Luggage;
import com.luggage.service.luggageservice.repository.AirportRepository;
import com.luggage.service.luggageservice.repository.LuggageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Transactional
@Service
public class LuggageServiceImpl {
    private LuggageRepository luggageRepository;
    private AirportRepository airportRepository;

    public LuggageServiceImpl(LuggageRepository luggageRepository, AirportRepository airportRepository) {
        this.luggageRepository = luggageRepository;
        this.airportRepository=airportRepository;
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
    public Optional<Luggage> findAirportByLuggageById(Integer id) {
        Optional<Luggage> luggageId = luggageRepository.findLuggageByAirport(id);
        return luggageId;
    }

  /*  public Optional<Luggage> findLuggageByAirport(String airport) {
        Optional<Luggage> luggageAirport = luggageRepository.findByAirport(airport);
        return luggageAirport;
    }*/
   // @Transactional
    public Luggage insertLuggage(Integer airportId, Luggage luggage) {
        Airport airport = airportRepository.findByAirportId(airportId);
        Luggage luggage1 = luggageRepository.findLuggageId(luggage.getLuggageId());
        luggage1.setAirports(airport);
        return this.luggageRepository.saveAndFlush(luggage1);
    }
}



