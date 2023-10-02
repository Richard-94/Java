package com.work.project.security.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.work.project.security.model.SportsEvents;
import com.work.project.security.repository.ImageRepository;
import com.work.project.security.repository.SportsEventsRepository;

import jakarta.persistence.EntityNotFoundException;


import com.work.project.security.checking.EventsControl;
import com.work.project.security.constants.Accessibility;

import com.work.project.security.model.ImageMetadata;
import com.work.project.security.model.Sponsors;
import com.work.project.security.exception.NotNullException;

@Service
public class SportService {
    @Autowired SportsEventsRepository sportsRepo;
    @Autowired @Qualifier("sports") private ObjectProvider<SportsEvents> sportsProvider;
    @Autowired EventsControl eventcontrol;
    @Autowired ImageService imgService;

    public SportsEvents createEvent(String title, String location, LocalTime time, LocalDate date, String price,
            String participants, String address, String description, String organizer, String info_event,
            Accessibility disabilities, String fileName, String filePath) {

        SportsEvents sports = sportsProvider.getObject();
        sports.setTitle(title);
        sports.setLocation(location);
        sports.setTime(time);
        sports.setDate(date);
        sports.setPrice(price);
        sports.setParticipants(participants);
        sports.setAddress(address);
        sports.setDescription(description);
        sports.setOrganizer(organizer);
        sports.setInfo_event(info_event);
        sports.setDisabilities(disabilities);

        // Create and set the image metadata
        //List<ImageMetadata> imageList = imgService.createImage(fileName, filePath);
        for (ImageMetadata image : imageList) {
            image.setEventImages(sports); // Set the reference to the sports event
        }

        sports.setImageMetadataList(imageList);

        // Save the sports event and associated image metadata
        sportsRepo.save(sports);

        return sports;
    }






	public SportsEvents saveSports(SportsEvents sport) {
        try {
            if (sport == null) {
                throw new IllegalArgumentException("Sports  object cannot be null.");
            }
            eventcontrol.controlNotNull(sport);
            return sportsRepo.save(sport);
        } catch (IllegalArgumentException e) {
            throw new NotNullException("Sport event is not valid for saving: " + e.getMessage());
        }
    }
	
	 public List<SportsEvents> getAllEvents() {
	    	List <SportsEvents> sport =  (List<SportsEvents>) sportsRepo.findAll();
	    	return sport;
	    }
	 
	 public SportsEvents findSport(Long id) {
	    	if(!sportsRepo.existsById(id)) {
	    		throw new EntityNotFoundException("No sport activity available at this moment!!!");
	    	}
	    	return sportsRepo.findById(id).get();
			
	    }

}

























//
//
//{
//	  "title": "Sample Sports Event",
//	  "location": "Sample Location",
//	  "time": "13:00:00",
//	  "date": "2023-09-10",
//	  "price": "Free",
//	  "participants": "100",
//	  "address": "123 Sample Street",
//	  "description": "A sample sports event description.",
//	  "organizer": "Sample Organizer",
//	  "info_event": "Sample event information",
//	  "disabilities": "PHYSICAL",
//	  "sponsors": [
//	    {
//	      "name": "Sponsor 1",
//	      "description": "Description of Sponsor 1"
//	    },
//	    {
//	      "name": "Sponsor 2",
//	      "description": "Description of Sponsor 2"
//	    }
//	  ],
//	  "imageMetadataList": [
//	    {
//	      "fileName": "image1.jpg",
//	      "filePath": "/images/image1.jpg"
//	    },
//	    {
//	      "fileName": "image2.jpg",
//	      "filePath": "/images/image2.jpg"
//	    }
//	  ]
//	}

//{
//	   "sports":{
//	        
//	  "title": "Sample Sports Event",
//	  "location": "Sample Location",
//	  "time": "13:00:00",
//	  "date": "2023-09-10",
//	  "price": "Free",
//	  "participants": "100",
//	  "address": "123 Sample Street",
//	  "description": "A sample sports event description.",
//	  "organizer": "Sample Organizer",
//	  "info_event": "Sample event information",
//	  "disabilities": "PHYSICAL",
//	  "sponsors": [
//	    {
//	      "name": "Sponsor 1",
//	      "description": "Description of Sponsor 1"
//	    },
//	    {
//	      "name": "Sponsor 2",
//	      "description": "Description of Sponsor 2"
//	    }
//	  ],
//	  "imageMetadataList": [
//	    {
//	      "fileName": "image1.jpg",
//	      "filePath": "/images/image1.jpg"
//	    },
//	    {
//	      "fileName": "image2.jpg",
//	      "filePath": "/images/image2.jpg"
//	    }
//	  ]
//	   }
//	  
//	 
//	}

