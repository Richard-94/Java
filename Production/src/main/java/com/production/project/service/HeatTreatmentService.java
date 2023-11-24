package com.production.project.service;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.production.project.costants.TypeOfProcessSpring;
import com.production.project.exception.NotNullException;
import com.production.project.model.Equipment;
import com.production.project.model.HeatTreatment;
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.Paintings;
import com.production.project.model.RawMaterials;
import com.production.project.model.Wrapping;
import com.production.project.repository.EquipmentRepository;
import com.production.project.repository.HeatTreatmentRepository;
import com.production.project.repository.ManufacturingApprovalRepository;
import com.production.project.repository.PaintingsRepository;
import com.production.project.repository.RawMaterialRepository;
import com.production.project.repository.WrappingRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class HeatTreatmentService {
	@Autowired @Qualifier("heating") private ObjectProvider<HeatTreatment> heatProvider;
	@Autowired HeatTreatmentRepository heatRepo;
	@Autowired WrappingRepository wrapRepo;
	@Autowired RawMaterialRepository rawRepo;
	@Autowired EquipmentRepository equipRepo;
	@Autowired ManufacturingApprovalRepository manRepo;
	@Autowired PaintingsRepository paintRepo;
	
	
	
	public void createHeatTreatment() throws NotNullException  {
		try{
			boolean heatId = heatRepo.existsByMachine("F9-");
			if(heatId) {
				throw new NotNullException("Processo trattamento termico esiste gia");
			}
			else {
				HeatTreatment heat = heatProvider.getObject();
				heat.setMachine("NP0-");
				heat.setProduced(0L);
				heat.setToProduce(100L);
				heat.setStatus(false);
				heat.setTypeOfProcessSpring(TypeOfProcessSpring.Trattamento_Termico);
				heatRepo.save(heat);
				System.out.println(heat + "saved");
			}
		}catch (NotNullException e) {
	        throw new NotNullException("Elemento esiste gia: " + e.getMessage());
	    } catch (Exception e) {
	        throw new RuntimeException("An unexpected error occurred: " + e.getMessage());
	    }
	}
	
	
	public HeatTreatment heatingFind(Long id) {
		if(!heatRepo.existsById(id)) {
			throw new EntityNotFoundException("Materiale non esiste!!!");
		}
		return heatRepo.findById(id).get();
	}
	
	public HeatTreatment startHeatTreatment(
			Long heatId,
			Long rawMatId,	
			Long equipId,
			Long approveId,
			Long paintId, 
			Long wrapId, 
			HeatTreatment raw) {
		  Optional<Equipment> equipMatIdVerify = equipRepo.findById(equipId);
		  Optional<RawMaterials> rawMatIdVerify = rawRepo.findById(rawMatId);
		  Optional<ManufacturingApproval> manuIdVerify = manRepo.findById(approveId);
		  Optional<Paintings> paintIdVerify = paintRepo.findById(paintId);
		  Optional<Wrapping> wrapIdVerify = wrapRepo.findById(wrapId);
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
		  if (!wrapIdVerify .isPresent()) {
				
			    throw new EntityNotFoundException("Avvolgimento non trovato");
			}
		 
		
		  
		  
		  Equipment findEquipId = equipMatIdVerify.get();
		  RawMaterials findRawMatId = rawMatIdVerify.get();
		  ManufacturingApproval findApprovalId = manuIdVerify.get();
		  Paintings findPaintId = paintIdVerify.get();
		  Wrapping findWrapId = wrapIdVerify.get();
		  
		  boolean controlIdEquip = findEquipId .getSetUpOk();
		  boolean controlIdRawMat = findRawMatId.getSetUpOk();
		  boolean controlIdApproval = findApprovalId.getSetUpOk();
		  boolean controlIdPaint = findPaintId.getSetUpOk();
		  Long controlQuantityWrap = findWrapId.getProduced();
		  boolean controlWrapStatus = findWrapId.getStatus();

		  if (controlWrapStatus  == false) {
		        throw new NotNullException("Fase di avvolgimento non iniziata");
		    }
		  
		  if (controlQuantityWrap < 300) {
		        throw new NotNullException("Produrre almeno 300 pezzi in fase di avvolgimento");
		    }
			
		  
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
		   
		    if (controlQuantityWrap < 300) {
		        throw new NotNullException("Produrre almeno 300 pezzi in fase di avvolgimento");
		    }
			
			if(!heatRepo.existsById(heatId)) {
				throw new EntityNotFoundException("Fase di trattamento termico non esiste");
			}
			
			
			
				HeatTreatment existingWrap = heatRepo.findById(heatId).get();
				existingWrap.setStatus(raw.getStatus());
			
				return heatRepo.save(existingWrap);
	}
	
	public HeatTreatment stopHeat(Long id,HeatTreatment raw) {
		boolean startHeating  =  heatRepo.existsByStatusIsTrue();
		if(!startHeating ) {
			throw new NotNullException("La fase di trattameno termico non iniziata");
		}
		HeatTreatment existingWrap = heatRepo.findById(id).get();
		existingWrap.setStatus(raw.getStatus());
		return heatRepo.save(existingWrap);
	}
	
	//@Scheduled(cron = "*/20 * * * * ?") // Runs every 20seconds
	
	//@Scheduled(cron = "10 * * * * ?") // Runs every minute
	public void startCounting(Long id) {
		 System.out.println("Scheduled method running...");
		 HeatTreatment existingWrapId = heatRepo.findById(id).get();
		
		//Long subtract = existingWrapId.getToProduce() - existingWrapId.getProduced() ;
		boolean startHeat  =  heatRepo.existsByStatusIsTrue();
		boolean controlToProduced = existingWrapId.getToProduce() > 0;
		//boolean controlProduced = existingWrapId.getProduced() > 10;
		
		if(startHeat && controlToProduced) {
			Long sumToProduce = existingWrapId.getToProduce()   ;
			Long sumProduced = existingWrapId.getProduced() ;
//		Long subtract = existingWrapId.getToProduce() - existingWrapId.getProduced() ;
//			Long sum = existingWrapId.getProduced() + 10 ;
			boolean controlProducedLessZero = existingWrapId.getToProduce()>0 && existingWrapId.getToProduce()<10;
			System.out.println(controlProducedLessZero+ "control");
			boolean controlToProducedLessZero = existingWrapId.getToProduce()<0;
			System.out.println(controlToProducedLessZero + " controlToProducedLessZero");
			
			if(controlToProducedLessZero) {
				throw new NotNullException("Pezzi finiti");
			}
			
			if(controlProducedLessZero) {
				 System.out.println("Executing block inside controlProducedLessZero");
				 long sumAll = existingWrapId.getToProduce() + existingWrapId.getProduced();
				existingWrapId.setProduced(sumAll);
				 System.out.println("the value of sum all is " + sumAll);
				
			}
			Long subtract = existingWrapId.getToProduce() - existingWrapId.getProduced() ;
			Long sum = existingWrapId.getProduced() + 10 ;
			existingWrapId.setToProduce(subtract);	
				existingWrapId.setProduced(sum);
				
				
			heatRepo.save(existingWrapId);				
				System.out.println("Scheduled method running...");
				System.out.println(sum + "added");
				System.out.println(subtract + "remaining");
			}
		
			
		
		else {
			throw new NotNullException("Pezzi finiti");
			
		}
		
	}
}
