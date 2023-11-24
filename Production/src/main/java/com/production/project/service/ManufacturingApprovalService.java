package com.production.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.production.project.checking.ProductionControl;
import com.production.project.exception.NotNullException;
import com.production.project.model.Equipment;
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.RawMaterials;
import com.production.project.repository.EquipmentRepository;
import com.production.project.repository.ManufacturingApprovalRepository;
import com.production.project.repository.RawMaterialRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ManufacturingApprovalService {
	@Autowired EquipmentRepository equipRepo;
	@Autowired ProductionControl prodControl;
	@Autowired ManufacturingApprovalRepository manuRepo;
	
	
	public ManufacturingApproval saveApproval(ManufacturingApproval approval) {
//	    boolean equipId = equipRepo.existsBySetUpOkIsTrue();
//	    if (!equipId) {
//	        throw new NotNullException("La fase di attrezzaggio non è ancora completata");
//	    }
	    prodControl.controlNotNullManufacturingApproval(approval);
	    return  manuRepo.save(approval);
	}
	
	public ManufacturingApproval updateManuApproval(Long id,Long rawMatId, ManufacturingApproval w) {
		  Optional<Equipment> rawMatIdVerify = equipRepo.findById(rawMatId);
		  Equipment find = rawMatIdVerify.get();
		  boolean controlId = find.getSetUpOk();
		    if (controlId == false) {
		        throw new NotNullException("Attrezzaggio non completata");
		    }
		if(!manuRepo.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		if(id != w.getId()) {
			throw new EntityNotFoundException("Id and UserID do not match!");
		}
		ManufacturingApproval existingMaterial= manuRepo.findById(id).get();
		existingMaterial.setBaseMeasurement(w.getBaseMeasurement());
		existingMaterial.setMeasurementRelieved(w.getMeasurementRelieved());
		existingMaterial.setPiecesTested(w.getPiecesTested());
		existingMaterial.setSetUpOk(w.getSetUpOk());
	
	    return manuRepo.save(existingMaterial);
	}
	
	public ManufacturingApproval manuApprovalFind(Long id) {
		if(!manuRepo.existsById(id)) {
			throw new EntityNotFoundException("Benestare Produzione non esiste");
		}
		return manuRepo.findById(id).get();
	}
	

}
