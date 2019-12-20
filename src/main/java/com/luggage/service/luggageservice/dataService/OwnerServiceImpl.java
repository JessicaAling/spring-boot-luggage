package com.luggage.service.luggageservice.dataService;

import com.luggage.service.luggageservice.exception.OwnerNotFoundException;
import com.luggage.service.luggageservice.model.Airport;
import com.luggage.service.luggageservice.model.Luggage;
import com.luggage.service.luggageservice.model.Owner;
import com.luggage.service.luggageservice.repository.AirportRepository;
import com.luggage.service.luggageservice.repository.LuggageRepository;
import com.luggage.service.luggageservice.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;


@Service
public class OwnerServiceImpl {

    private OwnerRepository ownerRepository;

    private LuggageRepository luggageRepository;

    private AirportRepository airportRepository;


    public OwnerServiceImpl(OwnerRepository ownerRepository, LuggageRepository luggageRepository, AirportRepository airportRepository) {
        this.ownerRepository = ownerRepository;
        this.luggageRepository = luggageRepository;
        this.airportRepository = airportRepository;
    }

    public Owner findOwner(String firstName, String surName) {
        Owner owner = ownerRepository.findOwner(firstName, surName);
        if (owner.equals(" ") || owner == null) {
            throw new OwnerNotFoundException("No name was found for this owner");
        }
        return owner;
    }

    public Owner updateOwnerInformation(Owner owner) {
        Owner ownerUpdate = ownerRepository.getOne(owner.getOwnerId());
        if (ownerUpdate.equals(" ") || ownerUpdate == null) {
            throw new OwnerNotFoundException("No id was found for this owner");
        }
        ownerUpdate.setLuggages(owner.getLuggages());
        ownerUpdate.setFirstName(owner.getFirstName());
        ownerUpdate.setSurName(owner.getSurName());
        ownerUpdate.setOwnerId(owner.getOwnerId());
        ownerUpdate.setPhoneNumber(owner.getPhoneNumber());

        try {
            return ownerRepository.save(ownerUpdate);
        } catch (Exception e) {
            throw new OwnerNotFoundException("Could not update Owner", e);
        }

    }

    public Owner deleteOwnerInformation(Owner owner) {
        Owner ownerDelete = ownerRepository.getOne(owner.getOwnerId());

        if (ownerDelete == null || ownerDelete.equals(" ")) {

            throw new OwnerNotFoundException("No id found when try to delete owner");
        }
        try {
            ownerRepository.delete(ownerDelete);
            return ownerDelete;
        } catch (Exception e) {
            throw new OwnerNotFoundException("Could not delete Owner", e);
        }

    }

    public Owner saveNewOwner(Owner owner) {
       try{
           return ownerRepository.saveAndFlush(owner);
       }catch (Exception e){
           throw new OwnerNotFoundException("Error when try to insert a new owner",e);
       }

    }
}

