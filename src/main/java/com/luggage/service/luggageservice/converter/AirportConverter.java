package com.luggage.service.luggageservice.converter;

import com.luggage.service.luggageservice.dataService.AirportServiceImpl;
import com.luggage.service.luggageservice.entity.Airport;
import com.luggage.service.luggageservice.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
@Component
public class AirportConverter implements Converter<Object, Airport>{

        //static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);

       @Autowired
    AirportRepository airportRepository;

    @Override
    public Airport convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        Airport airport= airportRepository.findByAirportId(id);
        return null;
    }

    /**
         * Gets UserProfile by Id
         * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
         */
       /* public UserProfile convert(Object element) {
            Integer id = Integer.parseInt((String)element);
            UserProfile profile= userProfileService.findById(id);
            logger.info("Profile : {}",profile);
            return profile;
        }*/
}
