package com.luggage.service.luggageservice.dataService;


import com.luggage.service.luggageservice.entity.Luggage;
import com.luggage.service.luggageservice.repository.LuggageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Transactional
@Service
public class LuggageServiceImpl {
    private LuggageRepository luggageRepository;

    public LuggageServiceImpl(LuggageRepository luggageRepository) {
        this.luggageRepository = luggageRepository;
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

    public List<Luggage> findLuggageByComment(String comment) {
        List<Luggage> luggageComment = luggageRepository.findByComment(comment);
        return luggageComment;
    }

    public Optional<Luggage> findLuggageByAirport(String airport) {
        Optional<Luggage> luggageAirport = luggageRepository.findByAirport(airport);
        return luggageAirport;
    }
}



