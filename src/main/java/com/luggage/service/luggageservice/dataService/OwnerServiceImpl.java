package com.luggage.service.luggageservice.dataService;

import com.luggage.service.luggageservice.exception.OwnerNotFoundException;
import com.luggage.service.luggageservice.model.Owner;
import com.luggage.service.luggageservice.repository.LuggageRepository;
import com.luggage.service.luggageservice.repository.OwnerRepository;
import org.springframework.stereotype.Service;


@Service
public class OwnerServiceImpl {

    private OwnerRepository ownerRepository;
    private LuggageRepository luggageRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository, LuggageRepository luggageRepository) {
        this.ownerRepository = ownerRepository;
        this.luggageRepository = luggageRepository;
    }

    public Owner findOwner(String firstName) {
        Owner owner = ownerRepository.findOwner(firstName);
        if (owner.equals(" ") || owner == null) {
            throw new OwnerNotFoundException("No name was found for this owner");
        }
        return owner;
    }

    public Owner updateOwnerInformation(Owner owner)  {
        Owner ownerUpdate = ownerRepository.getOne(owner.getOwnerId());

        if (ownerUpdate == null || ownerUpdate.equals(" ")) {

            throw new OwnerNotFoundException("No id found when update owner");
        }
        return ownerRepository.saveAndFlush(ownerUpdate);
    }

    public Owner deleteOwnerInformation(Owner owner) {
        Owner ownerDelete = ownerRepository.getOne(owner.getOwnerId());

        if (ownerDelete == null || ownerDelete.equals(" ")) {

            throw new OwnerNotFoundException("No id found when update owner");
        }
        ownerRepository.delete(ownerDelete);
        return ownerDelete;
    }
     /* public Owner findOwnerLuggage(String firstName) {
        Owner owner = ownerRepository.findOwner(firstName);
       // Luggage luggage = luggageRepository.findLuggageId(owner.getOwnerId());
       // owner.getLuggages();
        //List<Luggage> luggage = ownerRepository.findAllLuggageByAirportNameAndId(owner.getOwnerId(),firstName);
   return owner;
    }*/
}
