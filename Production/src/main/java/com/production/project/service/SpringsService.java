package com.production.project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.production.project.costants.OrderType;
import com.production.project.costants.TypeOfProcessSpring;
import com.production.project.exception.NotNullException;

import com.production.project.model.PreliminariActivities;
import com.production.project.model.Processing;
import com.production.project.model.Spraying;
import com.production.project.model.Springs;
import com.production.project.repository.PreliminariActivitiesRepository;
import com.production.project.repository.ProcessingRepository;
import com.production.project.repository.SpringRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SpringsService {
	@Autowired @Qualifier("springs") private ObjectProvider<Springs> springsProvider;
	@Autowired SpringRepository springsRepo;
	@Autowired PreliminariActivitiesRepository preliminariRepo;
	@Autowired ProcessingRepository processRepo;
	
	
	public Springs createSprings(String orderNumber, OrderType orderType, LocalDate orderDate,String client, String orderSerialNumber,
			String orderDescription, String steelType, TypeOfProcessSpring typeOfProcessSpring, Processing processing,PreliminariActivities preliminariActivities) {
		try {
			boolean springId1430 = springsRepo.existsByOrderNumber(orderNumber);
			
			Spraying spray = null;

			if(springId1430) {
				throw new NotNullException("Tipo di lavorazione per " + orderNumber + " esiste gia");
			}

			    Springs springs = springsProvider.getObject();
			    if ("Aisi".equalsIgnoreCase(springs.getSteelType())) {
			        processing.setSpraying(spray);
			    }
			    
			    springs.setClient(client);
			    springs.setOrderDate(orderDate);
			    springs.setOrderDescription(orderDescription);;
			    springs.setOrderNumber(orderNumber);
			    springs.setOrderSerialNumber(orderSerialNumber);
			    springs.setOrderType(orderType);
			    springs.setPreliminariActivities(preliminariActivities);
			    springs.setProcessing(processing);
			    springs.setTypeOfProcessSpring(typeOfProcessSpring);
			    springs.setSteelType(steelType);

			    springsRepo.save(springs);
			    return springs;
			    
		} catch (NotNullException e) {
	        throw new NotNullException("Element not found: " + e.getMessage());
	    } catch (Exception e) {
	        throw new RuntimeException("An unexpected error occurred: " + e.getMessage());
	    }
		
		
	}
	
	public List<Springs> showAllSprings(){
		List<Springs> allSprings = (List<Springs>) springsRepo.findAll();
		return allSprings;
	}
	
	public Springs findOrder(Long id) {
		if(!springsRepo.existsById(id)) {
			throw new EntityNotFoundException("L'ordine non esiste");
		}
		return springsRepo.findById(id).get();
	}

}
