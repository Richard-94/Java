package com.production.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.production.project.model.Equipment;
import com.production.project.model.Wrapping;
import com.production.project.service.SpringsService;
import com.production.project.service.WrappingService;


@RestController
@RequestMapping("/api/production/wrapping/start")
public class WrappingController {
	@Autowired WrappingService wrapServ;
	
	 @PatchMapping("{id}/{rawMatId}/{equipId}/{approvalId}/{paintId}")
	 @CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> startWrapping(@PathVariable Long id,
				@PathVariable Long rawMatId,
				@PathVariable Long equipId,
				@PathVariable Long approvalId,
				@PathVariable Long paintId, 
				@RequestBody Wrapping raw){
		 Wrapping rawMat = wrapServ.startWrapping(id,rawMatId,equipId,approvalId,paintId, raw);
			return new ResponseEntity<Wrapping>(rawMat, HttpStatus.OK);	
		}
	 
	 @PatchMapping("{id}")
	 @CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> stopWrapping(@PathVariable Long id, @RequestBody Wrapping raw){
		 Wrapping rawMat = wrapServ.stopWrapping(id, raw);
			return new ResponseEntity<Wrapping>(rawMat, HttpStatus.OK);	
		}
		

		@GetMapping("{id}")
		@CrossOrigin(origins = "*", maxAge = 3600)
	
		public ResponseEntity<?> getSingleEquipment(@PathVariable Long id){
			Wrapping pr = wrapServ.wrappingFind(id);
			return new ResponseEntity<Wrapping>(pr, HttpStatus.OK);

		}

}
