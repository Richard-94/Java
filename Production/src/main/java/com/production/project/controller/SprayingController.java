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


import com.production.project.model.Spraying;
import com.production.project.service.SprayingService;

@RestController
@RequestMapping("/api/production/spraying/start")
public class SprayingController {
	@Autowired SprayingService sprayServ;
	
	@PatchMapping("{id}/{grindId}")
	 @CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> updateEquipmentStart(@PathVariable Long id,
				@PathVariable Long grindId,
				@RequestBody Spraying raw){
		 Spraying rawMat = sprayServ.startSpraying(id,grindId,raw);
			return new ResponseEntity<Spraying>(rawMat, HttpStatus.OK);	
		}
	 
	 @PatchMapping("{id}")
	 @CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> stopHeatGrinding(@PathVariable Long id, @RequestBody Spraying raw){
		 Spraying rawMat = sprayServ.stopSpraying(id, raw);
			return new ResponseEntity<Spraying>(rawMat, HttpStatus.OK);	
		}
		

		@GetMapping("{id}")
		@CrossOrigin(origins = "*", maxAge = 3600)
	
		public ResponseEntity<?> getSingleEquipment(@PathVariable Long id){
			Spraying pr = sprayServ.sprayFind(id);
			return new ResponseEntity<Spraying>(pr, HttpStatus.OK);

		}


}
