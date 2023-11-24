package com.production.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.production.project.checking.ProductionControl;

import com.production.project.model.RawMaterials;
import com.production.project.repository.RawMaterialRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RawMaterialsService {
	@Autowired ProductionControl prodControl;
	@Autowired RawMaterialRepository rawMatRepo;
	
	public RawMaterials createRawMat(RawMaterials rawMat) {
			prodControl.controlRawMaterial(rawMat);
			return rawMatRepo.save(rawMat);
	}
	
	public RawMaterials updateRawMaterials(Long id, RawMaterials w) {
		if(!rawMatRepo.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		if(id != w.getId()) {
			throw new EntityNotFoundException("Id and UserID do not match!");
		}
		RawMaterials existingMaterial= rawMatRepo.findById(id).get();
		existingMaterial.setSteelType(w.getSteelType());
		existingMaterial.setSteelDiameter(w.getSteelDiameter());
		existingMaterial.setSteelKilos(w.getSteelKilos());
		existingMaterial.setSetUpOk(w.getSetUpOk());
		prodControl.controlRawMaterial(existingMaterial);
	    return rawMatRepo.save(existingMaterial);
	}
	
	public RawMaterials rawMaterialFind(Long id) {
		if(!rawMatRepo.existsById(id)) {
			throw new EntityNotFoundException("Materiale non esiste!!!");
		}
		return rawMatRepo.findById(id).get();
	}

}
