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


import com.production.project.model.Equipment;
import com.production.project.model.RawMaterials;
import com.production.project.service.EquipmentService;


@RestController
@RequestMapping("/api/production/equipment")
public class EquipmentController {
	@Autowired EquipmentService equipServ;
	
	 @PostMapping("/create")
		@CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> createEquipment(@RequestBody Equipment equip){
		 Equipment equipment = equipServ.saveEquipment(equip);
			return new ResponseEntity<Equipment>(equipment, HttpStatus.CREATED);
		}
	 

	 	@PutMapping("{id}/{rawMatId}")
		@CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> updateEquipment(@PathVariable Long id, @RequestBody Equipment raw,  @PathVariable Long rawMatId){
		 Equipment rawMat = equipServ.updateEquipment(id, rawMatId, raw);
			return new ResponseEntity<Equipment>(rawMat, HttpStatus.CREATED);	
		}
		

		@GetMapping("{id}")
		@CrossOrigin(origins = "*", maxAge = 3600)
	
		public ResponseEntity<?> getSingleEquipment(@PathVariable Long id){
			Equipment pr = equipServ.equipmentFind(id);
			return new ResponseEntity<Equipment>(pr, HttpStatus.OK);

		}
}
