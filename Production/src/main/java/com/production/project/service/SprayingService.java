package com.production.project.service;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.production.project.costants.TypeOfProcessSpring;
import com.production.project.exception.NotNullException;
import com.production.project.model.Grinding;
import com.production.project.model.HeatTreatment;
import com.production.project.model.Spraying;
import com.production.project.model.Wrapping;
import com.production.project.repository.GrindingRepository;
import com.production.project.repository.SprayingRepository;
import com.production.project.repository.WrappingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SprayingService {
	@Autowired @Qualifier("spraying") private ObjectProvider<Spraying> sprayProvider;
	@Autowired SprayingRepository sprayRepo;
	@Autowired GrindingRepository grindRepo;
	
	
	public void createSpraying() throws NotNullException  {
		try{
			boolean wrapId = sprayRepo.existsByMachine("C95-");
			if(wrapId) {
				throw new NotNullException("Processo avvolgimento esiste gia");
			}
			else {
				Spraying spray = sprayProvider.getObject();
				spray.setMachine("H13-");
				spray.setProduced(0L);
				spray.setToProduce(100L);
				spray.setStatus(false);
				spray.setTypeOfProcessSpring(TypeOfProcessSpring.Verniciatura);
				sprayRepo.save(spray);
				System.out.println(spray + "saved");
			}
		}catch (NotNullException e) {
	        throw new NotNullException("Elemento esiste gia: " + e.getMessage());
	    } catch (Exception e) {
	        throw new RuntimeException("An unexpected error occurred: " + e.getMessage());
	    }
	}
	
	public Spraying sprayFind(Long id) {
		if(!sprayRepo.existsById(id)) {
			throw new EntityNotFoundException("Materiale non esiste!!!");
		}
		return sprayRepo.findById(id).get();
	}
	
	public Spraying startSpraying(
			Long sprayId,
			Long grindId,
			Spraying raw) {
		 
		  Optional<Grinding> grindIdVerify =  grindRepo.findById(grindId);
		  if (!grindIdVerify.isPresent()) {
			
			    throw new EntityNotFoundException("grind not found");
			}
		 
		
		  
		 
		 Grinding findGrindId = grindIdVerify.get();
		 
		  Long controlQuantityGrind = findGrindId.getProduced();
		  boolean controlGrindStatus = findGrindId.getStatus();

		  if (controlGrindStatus   == false) {
		        throw new NotNullException("Fase di molatura non iniziata");
		    }
		  
		  if (controlQuantityGrind < 150) {
		        throw new NotNullException("Produrre almeno 150 pezzi molati");
		    }
			
			
			if(!grindRepo.existsById(grindId)) {
				throw new EntityNotFoundException("Fase di molatura non esiste");
			}
			
			
			
				Spraying existingWrap = sprayRepo.findById(sprayId).get();
				existingWrap.setStatus(raw.getStatus());
			
				return sprayRepo.save(existingWrap);
	}
	
	public Spraying stopSpraying(Long id,Spraying raw) {
		boolean startSpraying  =  sprayRepo.existsByStatusIsTrue();
		if(!startSpraying) {
			throw new NotNullException("La fase di molatura non iniziata");
		}
		Spraying existingGrind =sprayRepo.findById(id).get();
		existingGrind.setStatus(raw.getStatus());
		return sprayRepo.save(existingGrind);
	}
}
