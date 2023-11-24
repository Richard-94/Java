package com.production.project.checking;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.production.project.exception.NotNullException;
import com.production.project.model.Equipment;
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.Paintings;
import com.production.project.model.RawMaterials;
import com.production.project.repository.EquipmentRepository;
import com.production.project.repository.ManufacturingApprovalRepository;
import com.production.project.repository.PaintingsRepository;
import com.production.project.repository.ProcessingRepository;
import com.production.project.repository.RawMaterialRepository;
import com.production.project.repository.SpringRepository;

;

@Service
public class ProductionControl {
	@Autowired EquipmentRepository equipRepository;
	@Autowired ManufacturingApprovalRepository manufacRepository;
	@Autowired PaintingsRepository paintRepository;
	@Autowired ProcessingRepository processRepository;
	@Autowired RawMaterialRepository rawMatRepository;
	@Autowired SpringRepository springRepository;
	
	public RawMaterials controlRawMaterial(RawMaterials rawMat) {
		 
		
		if (StringUtils.isEmpty(rawMat.getSteelType())) {
			throw new NotNullException("Inserire il tipo di acciao");
		}

		if (rawMat.getSteelDiameter() == null ) {
			throw new NotNullException("Inserire il diametro del acciao");
		}
		if (rawMat.getSteelKilos() == null ) {
			throw new NotNullException("Inserire i kili necessari per la lavorazione");
		}
		
		if (rawMat.getSetUpOk() ==null) {
			throw new NotNullException("Confermare se i dati inseriti sono giusti");
		}
		
		return rawMat;
	}

	public Equipment controlNotNullEquipment(Equipment equip) {
		 boolean equipmentExists = equipRepository.existsBySetUpOkIsTrue();
			
			if(equipmentExists) {
				throw new NotNullException("Attrezzaggio già effettuato");
			}

		if (StringUtils.isEmpty(equip.getMachine())) {
			throw new NotNullException("Inserire il nome della machina");
		}

		if (StringUtils.isEmpty(equip.getCuttingEquipment())) {
			throw new NotNullException("Identificare il materiale per il taglio");
		}
		if (StringUtils.isEmpty(equip.getMeasurementEquipment())) {
			throw new NotNullException("Identificare attrezzo per le misurazione");
		}
		
		if (equip.getSetUpOk() ==null) {
			throw new NotNullException("Confermare se i dati inseriti sono giusti");
		}
		
		
		return equip;

	}
	
	public ManufacturingApproval controlNotNullManufacturingApproval(ManufacturingApproval manufac) {
//		 boolean manuApprovalExits = manufacRepository.existsBySetUpOkIsTrue();
//			
//			if(manuApprovalExits ) {
//				throw new NotNullException("Benestare produzione già effettuato");
//			}
		
		if (StringUtils.isEmpty(manufac.getMeasurementRelieved())) {
			throw new NotNullException("Inserire la misura rilevata");
		}

		if (StringUtils.isEmpty(manufac.getBaseMeasurement())) {
			throw new NotNullException("Inserire la misura base");
		}
		if (manufac.getPiecesTested() == null) {
			throw new NotNullException("Quanti pezzi sono stati testati?");
		}
		
		if (manufac.getSetUpOk() ==null) {
			throw new NotNullException("Confermare se i dati inseriti sono giusti");
		}
		
		
		return manufac;

	}
	
	public Paintings controlNotNullPaintings(Paintings painting) {
//		 boolean paintingExits = paintRepository.existsBySetUpOkIsTrue();
//			
//			if(paintingExits) {
//				throw new NotNullException("Verniciatura già effettuato");
//			}

		if (StringUtils.isEmpty(painting.getColor())) {
			throw new NotNullException("Inserire il tipo di colore");
		}
		if (painting.getTypeOfPaint() == null || painting.getTypeOfPaint().name().isEmpty()) {
		    throw new NotNullException("Inserire il tipo di vernice");
		}
		
		if (painting.getSetUpOk() ==null) {
			throw new NotNullException("Confermare se i dati inseriti sono giusti");
		}
		
		
		
		return painting;

	}




}
