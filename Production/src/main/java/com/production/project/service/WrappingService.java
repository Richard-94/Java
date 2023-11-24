package com.production.project.service;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.production.project.costants.TypeOfProcessSpring;
import com.production.project.exception.NotNullException;
import com.production.project.model.Equipment;
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.RawMaterials;
import com.production.project.model.Springs;
import com.production.project.model.Wrapping;
import com.production.project.model.Paintings;
import com.production.project.repository.EquipmentRepository;
import com.production.project.repository.ManufacturingApprovalRepository;
import com.production.project.repository.PaintingsRepository;
import com.production.project.repository.RawMaterialRepository;
import com.production.project.repository.SpringRepository;
import com.production.project.repository.WrappingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class WrappingService {
	@Autowired @Qualifier("wrapping") private ObjectProvider<Wrapping> wrappingProvider;
	@Autowired WrappingRepository wrapRepo;
	@Autowired RawMaterialRepository rawRepo;
	@Autowired EquipmentRepository equipRepo;
	@Autowired ManufacturingApprovalRepository manRepo;
	@Autowired PaintingsRepository paintRepo;
	
	
	public void createWrapping() throws NotNullException  {
		try{
			boolean wrapId = wrapRepo.existsByMachine("E24-");
			if(wrapId) {
				throw new NotNullException("Processo avvolgimento esiste gia");
			}
			else {
				Wrapping wrap = wrappingProvider.getObject();
				wrap.setMachine("H12-");
				wrap.setProduced(0L);
				wrap.setToProduce(100L);
				wrap.setStatus(false);
				wrap.setTypeOfProcessSpring(TypeOfProcessSpring.Avvolgimento);
				wrapRepo.save(wrap);
				System.out.println(wrap + "saved");
			}
		}catch (NotNullException e) {
	        throw new NotNullException("Elemento esiste gia: " + e.getMessage());
	    } catch (Exception e) {
	        throw new RuntimeException("An unexpected error occurred: " + e.getMessage());
	    }
		
	}
	
	public Wrapping wrappingFind(Long id) {
		if(!wrapRepo.existsById(id)) {
			throw new EntityNotFoundException("Materiale non esiste!!!");
		}
		return wrapRepo.findById(id).get();
	}
	
	
	public Wrapping startWrapping(
			Long wrapId, 
			Long rawMatId,	
			Long equipId,
			Long approveId,
			Long paintId, 
			Wrapping raw) {
		  Optional<Equipment> equipMatIdVerify = equipRepo.findById(equipId);
		  Optional<RawMaterials> rawMatIdVerify = rawRepo.findById(rawMatId);
		  Optional<ManufacturingApproval> manuIdVerify = manRepo.findById(approveId);
		  Optional<Paintings> paintIdVerify = paintRepo.findById(paintId);
		  if (!equipMatIdVerify.isPresent()) {
			
			    throw new EntityNotFoundException("Equipment not found");
			}
		  if (!manuIdVerify.isPresent()) {
				
			    throw new EntityNotFoundException("approval not found");
			}
		  if (!paintIdVerify.isPresent()) {
				
			    throw new EntityNotFoundException("paint not found");
			}
		  if (!rawMatIdVerify.isPresent()) {
				
			    throw new EntityNotFoundException("rawmat not found");
			}
		 
		
		  
		  
		  Equipment findEquipId = equipMatIdVerify.get();
		  RawMaterials findRawMatId = rawMatIdVerify.get();
		  ManufacturingApproval findApprovalId = manuIdVerify.get();
		  Paintings findPaintId = paintIdVerify.get();
		  
		  boolean controlIdEquip = findEquipId .getSetUpOk();
		  boolean controlIdRawMat = findRawMatId.getSetUpOk();
		  boolean controlIdApproval = findApprovalId.getSetUpOk();
		  boolean controlIdPaint = findPaintId.getSetUpOk();
		  
		  if (controlIdRawMat == false) {
		        throw new NotNullException("Identificazione materia prima non completata");
		    }
		  
		    if (controlIdEquip == false) {
		        throw new NotNullException("Attrezzaggio non completata");
		    }
		 
		   
		    if (controlIdApproval  == false) {
		        throw new NotNullException("benestare produzione non completata");
		    }
		    if (controlIdPaint  == false) {
		        throw new NotNullException("Operazione di rivestimento non completata");
		    }
			
			if(!wrapRepo.existsById(wrapId)) {
				throw new EntityNotFoundException("Fase di avvolgimento non esiste");
			}
			
				Wrapping existingWrap = wrapRepo.findById(wrapId).get();
				existingWrap.setStatus(raw.getStatus());
			
				return wrapRepo.save(existingWrap);
	}
	
	public Wrapping stopWrapping(Long id,Wrapping raw) {
		boolean startWrapping  =  wrapRepo.existsByStatusIsTrue();
		if(!startWrapping ) {
			throw new NotNullException("La fase di avvolgimento non iniziata");
		}
		Wrapping existingWrap = wrapRepo.findById(id).get();
		existingWrap.setStatus(raw.getStatus());
		return wrapRepo.save(existingWrap);
	}
	
	//@Scheduled(cron = "*/20 * * * * ?") // Runs every 20seconds
	
	//@Scheduled(cron = "10 * * * * ?") // Runs every minute	public void startCounting(Long id) {		 System.out.println("Scheduled method running...");		Wrapping existingWrapId = wrapRepo.findById(id).get();				//Long subtract = existingWrapId.getToProduce() - existingWrapId.getProduced() ;		boolean startWrapping  =  wrapRepo.existsByStatusIsTrue();		boolean controlToProduced = existingWrapId.getToProduce() > 0;		//boolean controlProduced = existingWrapId.getProduced() > 10;				if(startWrapping && controlToProduced) {			Long sumToProduce = existingWrapId.getToProduce()   ;			Long sumProduced = existingWrapId.getProduced() ;
//		Long subtract = existingWrapId.getToProduce() - existingWrapId.getProduced() ;
//			Long sum = existingWrapId.getProduced() + 10 ;			boolean controlProducedLessZero = existingWrapId.getToProduce()>0 && existingWrapId.getToProduce()<10;			System.out.println(controlProducedLessZero+ "control");			boolean controlToProducedLessZero = existingWrapId.getToProduce()<0;			System.out.println(controlToProducedLessZero + " controlToProducedLessZero");						if(controlToProducedLessZero) {				throw new NotNullException("Pezzi finiti");			}						if(controlProducedLessZero) {				 System.out.println("Executing block inside controlProducedLessZero");				 long sumAll = existingWrapId.getToProduce() + existingWrapId.getProduced();
				existingWrapId.setProduced(sumAll);
				 System.out.println("the value of sum all is " + sumAll);
				
			}
			Long subtract = existingWrapId.getToProduce() - existingWrapId.getProduced() ;
			Long sum = existingWrapId.getProduced() + 10 ;
			existingWrapId.setToProduce(subtract);	
				existingWrapId.setProduced(sum);
				
				
			wrapRepo.save(existingWrapId);				
				System.out.println("Scheduled method running...");
				System.out.println(sum + "added");
				System.out.println(subtract + "remaining");
			}
		
			
		
		else {
			throw new NotNullException("Pezzi finiti");
			
		}
		
	}
}
