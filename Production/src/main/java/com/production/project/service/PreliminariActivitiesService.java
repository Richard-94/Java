package com.production.project.service;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.production.project.exception.NotNullException;
import com.production.project.model.Equipment;
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.Paintings;
import com.production.project.model.PreliminariActivities;
import com.production.project.model.RawMaterials;
import com.production.project.model.Wrapping;
import com.production.project.repository.EquipmentRepository;
import com.production.project.repository.ManufacturingApprovalRepository;
import com.production.project.repository.PaintingsRepository;
import com.production.project.repository.PreliminariActivitiesRepository;
import com.production.project.repository.RawMaterialRepository;


@Service
public class PreliminariActivitiesService {
	@Autowired PreliminariActivitiesRepository  preliminariRepo;
	@Autowired EquipmentRepository equipRepo;
	@Autowired RawMaterialRepository rawRepo;
	@Autowired ManufacturingApprovalRepository manuRepo;
	@Autowired PaintingsRepository paintRepo;
	@Autowired @Qualifier("preliminari") private ObjectProvider<PreliminariActivities> preliminariProvider;
	
	
	public void saveActivities() throws NotNullException {
		try {
			boolean preliminariId = preliminariRepo.existsById(52L);
			if(preliminariId) {
				throw new NotNullException("Attivita preliminari gia salvati");
			}
			 	Long equipmentId= 5L;
			    Long rawMatId = 4L;
			    Long matApprovalId = 4L;
			    Long paintingId = 4L;
			    
			    Optional<Equipment> equipmentOptional = equipRepo.findById(equipmentId);
			    Optional<RawMaterials> rawMatOptional = rawRepo.findById(rawMatId);
			    Optional<ManufacturingApproval> manufacOptional = manuRepo.findById(matApprovalId );
			    Optional<Paintings> paintingOptional = paintRepo.findById(paintingId);
			    
			    Equipment equipment = equipmentOptional.orElseThrow(() -> new NotNullException("Equipment not found"));
			    RawMaterials rawMat = rawMatOptional.orElseThrow(() -> new NotNullException("RawMaterials not found"));
			    ManufacturingApproval manufacturing = manufacOptional.orElseThrow(() -> new NotNullException("ManufacturingApproval not found"));
			    Paintings paint = paintingOptional.orElseThrow(() -> new NotNullException("Paintings not found"));
			    
			    PreliminariActivities activities = preliminariProvider.getObject();
			    activities.setEquipment(equipment);
			    activities.setRawMaterials(rawMat);
			    activities.setManufacturingApproval(manufacturing);
			    activities.setPainting(paint);

			    preliminariRepo.save(activities);
			    
		} catch (NotNullException e) {
	        throw new NotNullException("Element not found: " + e.getMessage());
	    } catch (Exception e) {
	        throw new RuntimeException("An unexpected error occurred: " + e.getMessage());
	    }
	}




}
