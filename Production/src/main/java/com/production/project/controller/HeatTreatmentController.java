package com.production.project.controller;

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

import com.production.project.model.HeatTreatment;
import com.production.project.model.Wrapping;

import com.production.project.service.HeatTreatmentService;

@RestController
@RequestMapping("/api/production/heating/start")
public class HeatTreatmentController {
	@Autowired HeatTreatmentService heatServ;
	
	 @PatchMapping("{id}/{rawMatId}/{equipId}/{approvalId}/{paintId}/{wrapId}")
	 @CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> updateEquipmentStart(@PathVariable Long id,
				@PathVariable Long rawMatId,
				@PathVariable Long equipId,
				@PathVariable Long approvalId,
				@PathVariable Long paintId, 
				@PathVariable Long wrapId,
				@RequestBody HeatTreatment raw){
		 HeatTreatment rawMat = heatServ.startHeatTreatment(id,rawMatId,equipId,approvalId,paintId,wrapId, raw);
			return new ResponseEntity<HeatTreatment>(rawMat, HttpStatus.OK);	
		}
	 
	 @PatchMapping("{id}")
	 @CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> stopHeatTreatment(@PathVariable Long id, @RequestBody HeatTreatment raw){
		 HeatTreatment rawMat = heatServ.stopHeat(id, raw);
			return new ResponseEntity<HeatTreatment>(rawMat, HttpStatus.OK);	
		}
		

		@GetMapping("{id}")
		@CrossOrigin(origins = "*", maxAge = 3600)
	
		public ResponseEntity<?> getSingleEquipment(@PathVariable Long id){
			HeatTreatment pr = heatServ.heatingFind(id);
			return new ResponseEntity<HeatTreatment>(pr, HttpStatus.OK);

		}


}
