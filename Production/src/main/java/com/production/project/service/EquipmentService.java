package com.production.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.production.project.checking.ProductionControl;
import com.production.project.exception.NotNullException;
import com.production.project.model.Equipment;
import com.production.project.model.RawMaterials;
import com.production.project.repository.EquipmentRepository;
import com.production.project.repository.RawMaterialRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EquipmentService {
	@Autowired EquipmentRepository equipRepo;
	@Autowired ProductionControl prodControl;
	@Autowired RawMaterialRepository rawMatRepo;
	
	
	public Equipment saveEquipment(Equipment equip) {
//	    boolean rawMatId = rawMatRepo.existsBySetUpOkIsTrue();
//	    if (!rawMatId) {
//	        throw new NotNullException("Identificazione della materia non è ancora completata");
//	    }
	    prodControl.controlNotNullEquipment(equip);
	    return equipRepo.save(equip);
	}
	
	public Equipment updateEquipment(Long id,Long rawMatId, Equipment w) {
		  Optional<RawMaterials> rawMatIdVerify = rawMatRepo.findById(rawMatId);
		  RawMaterials find = rawMatIdVerify.get();
		  boolean controlId = find.getSetUpOk();
		    if (controlId == false) {
		        throw new NotNullException("Identificazione materia prima non completata");
		    }
		if(!equipRepo.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		if(id != w.getId()) {
			throw new EntityNotFoundException("Id and UserID do not match!");
		}
		Equipment existingMaterial= equipRepo.findById(id).get();
		existingMaterial.setCuttingEquipment(w.getCuttingEquipment());
		existingMaterial.setMachine(w.getMachine());
		existingMaterial.setMeasurementEquipment(w.getMeasurementEquipment());
		existingMaterial.setSetUpOk(w.getSetUpOk());
	
	    return equipRepo.save(existingMaterial);
	}
	
	public Equipment equipmentFind(Long id) {
		if(!equipRepo.existsById(id)) {
			throw new EntityNotFoundException("Materiale non esiste!!!");
		}
		return equipRepo.findById(id).get();
	}
}
