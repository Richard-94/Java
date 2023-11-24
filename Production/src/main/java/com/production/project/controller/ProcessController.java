package com.production.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.production.project.model.Equipment;
import com.production.project.model.Processing;
import com.production.project.service.EquipmentService;
import com.production.project.service.ProcessingService;

@RestController
@RequestMapping("/api/production/process")
public class ProcessController {
	
	@Autowired ProcessingService proServ;
	
//	 @PostMapping("/create")
//		@CrossOrigin(origins = "*", maxAge = 3600)
//		public ResponseEntity<?> createEquipment(@RequestBody Processing process){
//		 Processing equipment = proServ.saveProcess(process);
//			return new ResponseEntity<Processing>(equipment, HttpStatus.CREATED);
//		}

}
