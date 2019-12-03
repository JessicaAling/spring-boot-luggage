package com.luggage.service.luggageservice.repository;

import com.luggage.service.luggageservice.entity.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LuggageRepository extends JpaRepository<Luggage,Integer> {
    @Override
    List<Luggage> findAll();
}
