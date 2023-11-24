package com.production.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.production.project.checking.ProductionControl;
import com.production.project.exception.NotNullException;
import com.production.project.model.Equipment;
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.Paintings;

import com.production.project.repository.ManufacturingApprovalRepository;
import com.production.project.repository.PaintingsRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class PaintingService {
	@Autowired PaintingsRepository paintRepo;
	@Autowired ProductionControl prodControl;
	@Autowired ManufacturingApprovalRepository manuRepo;
	
	public Paintings savePainting(Paintings paint) {
//	    boolean paintId = manuRepo.existsBySetUpOkIsTrue();
//	    if (!paintId) {
//	        throw new NotNullException("Benestare Produzione non è ancora completata");
//	    }
	    prodControl.controlNotNullPaintings(paint);
	    return paintRepo.save(paint);
	}
	
	public Paintings updatePaint(Long id, Paintings w, Long rawMatId) {
		 Optional<ManufacturingApproval> rawMatIdVerify = manuRepo.findById(rawMatId);
		 ManufacturingApproval find = rawMatIdVerify.get();
		  boolean controlId = find.getSetUpOk();
		    if (controlId == false) {
		        throw new NotNullException("Benestare produzione  non completata");
		    }
		if(!paintRepo.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		if(id != w.getId()) {
			throw new EntityNotFoundException("Id and UserID do not match!");
		}
		Paintings existingMaterial= paintRepo.findById(id).get();
		existingMaterial.setColor(w.getColor());
		existingMaterial.setTypeOfPaint(w.getTypeOfPaint());
		
		existingMaterial.setSetUpOk(w.getSetUpOk());
	
	    return paintRepo.save(existingMaterial);
	}
	
	public Paintings paintFind(Long id) {
		if(!paintRepo.existsById(id)) {
			throw new EntityNotFoundException("Tivestimento  non esiste");
		}
		return paintRepo.findById(id).get();
	}

}
