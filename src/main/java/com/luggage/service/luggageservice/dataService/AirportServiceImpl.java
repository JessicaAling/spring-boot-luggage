package com.luggage.service.luggageservice.dataService;


import com.luggage.service.luggageservice.entity.Airport;
import com.luggage.service.luggageservice.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class AirportServiceImpl {

        private AirportRepository airportRepository;

public AirportServiceImpl(AirportRepository airportRepository){
    this.airportRepository=airportRepository;
}

    public List<Airport> findAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports;
    }

    public Optional<Airport> findAirportById(int id) {
      Optional<Airport> airportId = airportRepository.findById(id);
      return airportId;


    }

    public Optional<Airport>  findAirportByName(String name) {
        Optional<Airport>  airportName = airportRepository.findByName(name);
        return airportName;

    }

    public String findAirportByLocation(String location) {
      String airportLocation = airportRepository.findByLocation(location);
      return airportLocation;
    }
    public Optional<Airport> findNameById(int id){
        Optional<Airport> airportName = airportRepository.findNameById(id);
        return airportName;
    }

}
