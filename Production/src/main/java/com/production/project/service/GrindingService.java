package com.production.project.service;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.production.project.costants.TypeOfProcessSpring;
import com.production.project.exception.NotNullException;
import com.production.project.model.Equipment;
import com.production.project.model.Grinding;
import com.production.project.model.HeatTreatment;
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.Paintings;
import com.production.project.model.RawMaterials;
import com.production.project.model.Wrapping;
import com.production.project.repository.GrindingRepository;
import com.production.project.repository.HeatTreatmentRepository;
import com.production.project.repository.WrappingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GrindingService {
	@Autowired @Qualifier("grinding") private ObjectProvider<Grinding> grindProvider;
	@Autowired GrindingRepository grindRepo;
	@Autowired HeatTreatmentRepository heatRepo;
	
	
	public void createGrinding() throws NotNullException  {
		try{
			boolean grindId = grindRepo.existsByMachine("M10-");
			if(grindId) {
				throw new NotNullException("Processo molatura esiste gia");
			}
			else {
				Grinding grind = grindProvider.getObject();
				grind.setMachine("XC9-");
				grind.setProduced(0L);
				grind.setToProduce(100L);
				grind.setStatus(false);
				grind.setTypeOfProcessSpring(TypeOfProcessSpring.Molatura);
				grindRepo.save(grind );
				System.out.println(grind  + "saved");
			}
		}catch (NotNullException e) {
	        throw new NotNullException("Elemento esiste gia: " + e.getMessage());
	    } catch (Exception e) {
	        throw new RuntimeException("An unexpected error occurred: " + e.getMessage());
	    }
	}
	
	public Optional<Grinding> grindFind(Long id) {
	    if (!grindRepo.existsById(id)) {
	        throw new EntityNotFoundException("Materiale non esiste!!!");
	    }
	    return grindRepo.findById(id);
	}

	
	public Grinding startGrinding(
			Long grindId,
			Long heatId,
			Grinding raw) {
		 
		  Optional<HeatTreatment> heatIdVerify =  heatRepo.findById(heatId);
		  if (!heatIdVerify.isPresent()) {
			
			    throw new EntityNotFoundException("heat not found");
			}
		 
		
		  
		 
		  HeatTreatment findheatId = heatIdVerify.get();
		 
		  Long controlQuantityHeat = findheatId.getProduced();
		  boolean controlHeatStatus = findheatId.getStatus();

		  if (controlHeatStatus   == false) {
		        throw new NotNullException("Fase di trattamento termico non iniziata");
		    }
		  
		  if (controlQuantityHeat < 200) {
		        throw new NotNullException("Produrre almeno 200 pezzi in fase di trattamento termico");
		    }
			
			
			if(!grindRepo.existsById(grindId)) {
				throw new EntityNotFoundException("Fase di molatura non esiste");
			}
			
			
			
				Grinding existingWrap = grindRepo.findById(grindId).get();
				existingWrap.setStatus(raw.getStatus());
			
				return grindRepo.save(existingWrap);
	}
	
	public Grinding stopGrinding(Long id,Grinding raw) {
		boolean startGrinding  =  grindRepo.existsByStatusIsTrue();
		if(!startGrinding ) {
			throw new NotNullException("La fase di molatura non iniziata");
		}
		Grinding existingGrind = grindRepo.findById(id).get();
		existingGrind.setStatus(raw.getStatus());
		return grindRepo.save(existingGrind);
	}

	

}
