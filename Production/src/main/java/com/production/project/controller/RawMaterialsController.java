package com.production.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.production.project.model.RawMaterials;
import com.production.project.service.RawMaterialsService;

@RestController
@RequestMapping("/api/production/rawmaterials")
public class RawMaterialsController {
	@Autowired RawMaterialsService rawMatServ;
	
	 @PostMapping("/create")
		@CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> createEquipment(@RequestBody RawMaterials rawMat){
		 RawMaterials raw = rawMatServ. createRawMat(rawMat);
			return new ResponseEntity<RawMaterials>(raw, HttpStatus.CREATED);
		}
	 
	 

		@PutMapping("{id}")
		@CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> updateRawMaterials(@PathVariable Long id, @RequestBody RawMaterials raw){
			RawMaterials rawMat = rawMatServ.updateRawMaterials(id, raw);
			return new ResponseEntity<RawMaterials>(rawMat, HttpStatus.CREATED);	
		}
		

		@GetMapping("{id}")
		@CrossOrigin(origins = "*", maxAge = 3600)
	
		public ResponseEntity<?> getSingleMaterial(@PathVariable Long id){
			RawMaterials pr = rawMatServ.rawMaterialFind(id);
			return new ResponseEntity<RawMaterials>(pr, HttpStatus.OK);

		}

}
