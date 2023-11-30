package com.production.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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

import com.production.project.costants.OrderType;
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
class SpringTesting {
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
	@Disabled
	void testGeSprings() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("Finding a spring with an id")
	@Disabled
	void testSuccessGetSingleOrder() {
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
			
			
		PreliminariActivities acti = preProvider.getObject();
			acti.setEquipment(equip);
			acti.setManufacturingApproval(approval);
			acti.setPainting(paint);
			acti.setRawMaterials(rawMat);
			preRepo.save(acti);
			
			
		HeatTreatment heat = heatProvider.getObject();
			heat.setMachine("F90-");
			heat.setProduced(0L);
			heat.setStatus(false);
			heat.setToProduce(60000L);
			heat.setTypeOfProcessSpring(TypeOfProcessSpring.Trattamento_Termico);
			heatRepo.save(heat);
			
		Spraying spray = sprayProvider.getObject();
			spray.setMachine("C65-");
			spray.setProduced(0L);
			spray.setStatus(false);
			spray.setToProduce(60000L);
			spray.setTypeOfProcessSpring(TypeOfProcessSpring.Verniciatura);
			sprayRepo.save(spray);
			
		Wrapping wrap = wrapProvider.getObject();
			wrap.setMachine("X95-");
			wrap.setProduced(0L);
			wrap.setStatus(false);
			wrap.setToProduce(60000L);
			wrap.setTypeOfProcessSpring(TypeOfProcessSpring.Avvolgimento);
			wrapRepo.save(wrap);
			
		Grinding grind = grindProvider.getObject();
			grind.setMachine("S6521/");
			grind.setProduced(0L);
			grind.setStatus(false);
			grind.setToProduce(60000L);
			grind.setTypeOfProcessSpring(TypeOfProcessSpring.Molatura);
			grindRepo.save(grind);
			
		Processing process = processProvider.getObject();
			process.setGrinding(grind);
			process.setHeatTreament(heat);
			process.setSpraying(spray);
			process.setWrapping(wrap);
			proRepo.save(process);
		

		Springs spring = springsProvider.getObject();
		spring.setClient("P60");
		spring.setOrderDate(LocalDate.of(2022, 12, 11));
		spring.setOrderDescription("Acciao per molle");
		spring.setOrderNumber("258");
		spring.setOrderSerialNumber("256893/2");
		spring.setOrderType(OrderType.Molle);
		spring.setSteelType("Aisi");
		spring.setTypeOfProcessSpring(TypeOfProcessSpring.Avvolgimento);
		spring.setPreliminariActivities(acti);
		spring.setProcessing(process);
		springRepo.save(spring);
		
		System.out.println(spring);
		
		String url = "http://localhost:8083/api/production/springs/" + spring.getId();
		ResponseEntity <Springs> resp = restTemplate.getForEntity(url, Springs.class);
		
		Springs springBody = resp.getBody();
		System.out.println(springBody);
		HttpStatusCode code =  resp.getStatusCode();
		System.out.println(code);
		assertThat(code).isEqualTo(HttpStatus.OK);
		assertThat(springBody.getId()).isEqualTo(spring.getId());
		
	}
	
	@Test
	@DisplayName("Finding a spring with a wrong id")
	void testFailureGetSingleOrder() {
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
		
		
	PreliminariActivities acti = preProvider.getObject();
		acti.setEquipment(equip);
		acti.setManufacturingApproval(approval);
		acti.setPainting(paint);
		acti.setRawMaterials(rawMat);
		preRepo.save(acti);
		
		
	HeatTreatment heat = heatProvider.getObject();
		heat.setMachine("F90-");
		heat.setProduced(0L);
		heat.setStatus(false);
		heat.setToProduce(60000L);
		heat.setTypeOfProcessSpring(TypeOfProcessSpring.Trattamento_Termico);
		heatRepo.save(heat);
		
	Spraying spray = sprayProvider.getObject();
		spray.setMachine("C65-");
		spray.setProduced(0L);
		spray.setStatus(false);
		spray.setToProduce(60000L);
		spray.setTypeOfProcessSpring(TypeOfProcessSpring.Verniciatura);
		sprayRepo.save(spray);
		
	Wrapping wrap = wrapProvider.getObject();
		wrap.setMachine("X95-");
		wrap.setProduced(0L);
		wrap.setStatus(false);
		wrap.setToProduce(60000L);
		wrap.setTypeOfProcessSpring(TypeOfProcessSpring.Avvolgimento);
		wrapRepo.save(wrap);
		
	Grinding grind = grindProvider.getObject();
		grind.setMachine("S6521/");
		grind.setProduced(0L);
		grind.setStatus(false);
		grind.setToProduce(60000L);
		grind.setTypeOfProcessSpring(TypeOfProcessSpring.Molatura);
		grindRepo.save(grind);
		
	Processing process = processProvider.getObject();
		process.setGrinding(grind);
		process.setHeatTreament(heat);
		process.setSpraying(spray);
		process.setWrapping(wrap);
		proRepo.save(process);
	

	Springs spring = springsProvider.getObject();
	spring.setClient("P60");
	spring.setOrderDate(LocalDate.of(2022, 12, 11));
	spring.setOrderDescription("Acciao per molle");
	spring.setOrderNumber("258");
	spring.setOrderSerialNumber("256893/2");
	spring.setOrderType(OrderType.Molle);
	spring.setSteelType("Aisi");
	spring.setTypeOfProcessSpring(TypeOfProcessSpring.Avvolgimento);
	spring.setPreliminariActivities(acti);
	spring.setProcessing(process);
	springRepo.save(spring);
	
	System.out.println(spring);
	
	String url = "http://localhost:8083/api/production/springs/52";
	ResponseEntity <String> resp = restTemplate.getForEntity(url, String.class);
	
	String testError = resp.getBody();
	System.out.println(testError );
	HttpStatusCode code =  resp.getStatusCode();
	System.out.println(code);
	assertThat(code).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	//assertThat(springBody.getId()).isEqualTo(spring.getId());
		
	}


}
