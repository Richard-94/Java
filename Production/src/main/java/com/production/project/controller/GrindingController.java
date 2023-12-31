package com.production.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.production.project.model.Grinding;
import com.production.project.model.HeatTreatment;
import com.production.project.service.GrindingService;
import com.production.project.service.HeatTreatmentService;

@RestController
@RequestMapping("/api/production/grinding/start")
public class GrindingController {
	@Autowired GrindingService grindServ;
	
	
	@PatchMapping("{id}/{heatId}")
	 @CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> updateEquipmentStart(@PathVariable Long id,
				@PathVariable Long heatId,
				@RequestBody Grinding raw){
		 Grinding rawMat = grindServ.startGrinding(id,heatId, raw);
			return new ResponseEntity<Grinding>(rawMat, HttpStatus.OK);	
		}
	 
	 @PatchMapping("{id}")
	 @CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> stopHeatGrinding(@PathVariable Long id, @RequestBody Grinding raw){
		 Grinding rawMat = grindServ.stopGrinding(id, raw);
		 System.out.println(raw);
			return new ResponseEntity<Grinding>(rawMat, HttpStatus.ACCEPTED);	
		}
		

	 @GetMapping("{id}")
	 @CrossOrigin(origins = "*", maxAge = 3600)
	 public ResponseEntity<?> getSingleEquipment(@PathVariable Long id) {
	     Optional<Grinding> optionalGrinding = grindServ.grindFind(id);

	     if (optionalGrinding.isPresent()) {
	         Grinding pr = optionalGrinding.get();
	         
	         return new ResponseEntity<Grinding>(pr, HttpStatus.OK);
	     } else {
	         // Handle the case where the entity is not found
	         return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
	     }
	 }


}
