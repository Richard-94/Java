package com.production.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.production.project.costants.TypeOfPaint;
import com.production.project.costants.TypeOfProcessSpring;
import com.production.project.model.Equipment;
import com.production.project.model.Grinding;
import com.production.project.model.HeatTreatment;
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.Paintings;
import com.production.project.model.PreliminariActivities;
import com.production.project.model.Processing;
import com.production.project.model.RawMaterials;
import com.production.project.model.Spraying;
import com.production.project.model.Springs;
import com.production.project.model.Wrapping;
import com.production.project.repository.EquipmentRepository;
import com.production.project.repository.GrindingRepository;
import com.production.project.repository.HeatTreatmentRepository;
import com.production.project.repository.ManufacturingApprovalRepository;
import com.production.project.repository.PaintingsRepository;
import com.production.project.repository.PreliminariActivitiesRepository;
import com.production.project.repository.ProcessingRepository;
import com.production.project.repository.RawMaterialRepository;
import com.production.project.repository.SprayingRepository;
import com.production.project.repository.SpringRepository;
import com.production.project.repository.WrappingRepository;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class StartWrappingTest {
	@Autowired @Qualifier("springs") private ObjectProvider<Springs> springsProvider;
	@Autowired SpringRepository springRepo;
	@Autowired RawMaterialRepository rawRepo;
	@Autowired EquipmentRepository equipRepo;
	@Autowired ManufacturingApprovalRepository manuRepo;
	@Autowired PaintingsRepository paintRepo;
	@Autowired PreliminariActivitiesRepository preRepo;
	@Autowired HeatTreatmentRepository heatRepo;
	@Autowired SprayingRepository sprayRepo;
	@Autowired WrappingRepository wrapRepo;
	@Autowired GrindingRepository grindRepo;
	@Autowired ProcessingRepository proRepo;
	
	
	
	@Autowired @Qualifier("preliminari") ObjectProvider<PreliminariActivities> preProvider;
	@Autowired @Qualifier("processing") ObjectProvider<Processing> processProvider;
	@Autowired @Qualifier("materials") ObjectProvider<RawMaterials> rawProvider;
	@Autowired @Qualifier("equipment") ObjectProvider<Equipment> equipProvider;
	@Autowired @Qualifier("approval") ObjectProvider<ManufacturingApproval> approvalProvider;
	@Autowired @Qualifier("painting") ObjectProvider<Paintings> paintProvider;
	@Autowired @Qualifier("heating") ObjectProvider<HeatTreatment> heatProvider;
	@Autowired @Qualifier("spraying") ObjectProvider <Spraying> sprayProvider;
	@Autowired @Qualifier("grinding") ObjectProvider<Grinding> grindProvider;
	@Autowired @Qualifier("wrapping") ObjectProvider<Wrapping> wrapProvider;
	
	@Autowired TestRestTemplate restTemplate; //simulare chiamate al server come postman

	@Test
	void testStartWrapping() {
		RawMaterials rawMat = rawProvider.getObject();
		rawMat.setSetUpOk(false);
		rawMat.setSteelDiameter(50);
		rawMat.setSteelKilos(2000L);
		rawMat.setSteelType("C95");
		rawRepo.save(rawMat);
		
		Equipment equip = equipProvider.getObject();
			equip.setCuttingEquipment("forbici");
			equip.setMachine("Tornio");
			equip.setMeasurementEquipment("Metro");
			equip.setSetUpOk(false);
			equipRepo.save(equip);
			
		ManufacturingApproval approval = approvalProvider.getObject();
			approval.setBaseMeasurement("22-100");
			approval.setMeasurementRelieved("252-200");
			approval.setPiecesTested(20);
			approval.setSetUpOk(false);
			manuRepo.save(approval);
			
		Paintings paint = paintProvider.getObject();
			paint.setColor("Red");
			paint.setSetUpOk(false);
			paint.setTypeOfPaint(TypeOfPaint.Vernice_acrilica);
			paintRepo.save(paint);
			

		Wrapping wrap = wrapProvider.getObject();
		wrap.setMachine("X95-");
		wrap.setProduced(0L);
		wrap.setStatus(false);
		wrap.setToProduce(60000L);
		wrap.setTypeOfProcessSpring(TypeOfProcessSpring.Avvolgimento);
		wrapRepo.save(wrap);
		
		String url = "http://localhost:8083/api/production/wrapping/start/" + wrap.getId() + "/" + rawMat.getId() + "/" + equip.getId() + "/" + approval.getId() + "/" + paint.getId();
		System.out.println(url);
		
		Wrapping existingWrap =  wrapRepo.findById(wrap.getId()).get();
		existingWrap.setStatus(true);
		 wrapRepo.save(existingWrap);
		
		 ResponseEntity <Wrapping> resp = restTemplate.getForEntity(url, Wrapping.class);
		
		
		
		
		
		Wrapping wrapBody = resp.getBody();
		System.out.println(wrapBody);
		HttpStatusCode code =  resp.getStatusCode();
		System.out.println(code);
		assertThat(code).isEqualTo(HttpStatus.OK);
		//assertThat(wrapBody.getId()).isEqualTo(spring.getId());
		
	}

}
