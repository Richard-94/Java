package com.production.project.service;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.production.project.exception.NotNullException;
import com.production.project.model.Equipment;
import com.production.project.model.Grinding;
import com.production.project.model.HeatTreatment;
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.Paintings;
import com.production.project.model.PreliminariActivities;
import com.production.project.model.Processing;
import com.production.project.model.RawMaterials;
import com.production.project.model.Spraying;
import com.production.project.model.Wrapping;
import com.production.project.repository.GrindingRepository;
import com.production.project.repository.HeatTreatmentRepository;
import com.production.project.repository.ProcessingRepository;
import com.production.project.repository.SprayingRepository;
import com.production.project.repository.WrappingRepository;

@Service
public class ProcessingService {
	@Autowired ProcessingRepository processRepo;
	@Autowired @Qualifier("processing") private ObjectProvider<Processing> wrappingProvider;
	@Autowired GrindingRepository grindRepo;
	@Autowired SprayingRepository sprayRepo;
	@Autowired HeatTreatmentRepository heatRepo;
	@Autowired WrappingRepository wrapRepo;
	
	
	public void saveProcess() throws NotNullException {
		
		try {
			boolean processId = processRepo.existsById(202L);
			if(!processId) {
				throw new NotNullException("Lavorazioni previste gia salvati");
			}
			 	Long grindingId= 1452L;
			    Long heatTreatmentId = 1302L;
			    Long sprayingId = 1802L;
			    Long wrappingId = 1102L;
			    
			    Optional<Grinding> grindingOptional = grindRepo.findById(grindingId);
			    Optional<HeatTreatment> heatingOptional = heatRepo.findById(heatTreatmentId);
			    Optional<Spraying> sprayingOptional = sprayRepo.findById(sprayingId);
			    Optional<Wrapping> wrappingOptional = wrapRepo.findById(wrappingId);
			    
			    Grinding grinding = grindingOptional.orElseThrow(() -> new NotNullException("Attivita molatura non trovata"));
			    Spraying spraying = sprayingOptional.orElseThrow(() -> new NotNullException("Attivita verniciatura non trovata"));
			    HeatTreatment heating = heatingOptional.orElseThrow(() -> new NotNullException("Attivita trattamento termico non trovata"));
			    Wrapping wrapping = wrappingOptional.orElseThrow(() -> new NotNullException("Attivita avvolgimento non trovata"));
			    
			    Processing process = wrappingProvider.getObject();
			    process.setGrinding(grinding);
			    process.setSpraying(spraying);
			    process.setHeatTreament(heating);
			    process.setWrapping(wrapping);

			    processRepo.save(process);
			    
		} catch (NotNullException e) {
	        throw new NotNullException("Element not found: " + e.getMessage());
	    } catch (Exception e) {
	        throw new RuntimeException("An unexpected error occurred: " + e.getMessage());
	    }
	    
	}


}
