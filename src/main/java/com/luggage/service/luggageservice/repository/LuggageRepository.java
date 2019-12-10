package com.luggage.service.luggageservice.repository;

import com.luggage.service.luggageservice.entity.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LuggageRepository extends JpaRepository<Luggage, Integer> {

       List<Luggage> findAll();

        @Query("SELECT u FROM Luggage u WHERE u.shelf = :shelf")
        Optional<Luggage> findByShelf(String shelf);

        @Query("SELECT a FROM  Luggage a where a.luggageId = :id")
        Optional<Luggage> findLuggageById(@Param("id") Integer id);

        //update comment instead of search for a comment?
        @Query("SELECT a FROM  Luggage a where a.comment = :comment")
        List<Luggage> findByComment(String comment);

        @Query("SELECT a.airport FROM  Luggage a where a.airport = :airport")
        Optional<Luggage> findByAirport(String airport);




    }
