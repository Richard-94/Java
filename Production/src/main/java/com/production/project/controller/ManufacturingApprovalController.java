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
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.RawMaterials;
import com.production.project.service.EquipmentService;
import com.production.project.service.ManufacturingApprovalService;

@RestController
@RequestMapping("/api/production/approval")
public class ManufacturingApprovalController {
	@Autowired ManufacturingApprovalService manuServ;
	
	 @PostMapping("/create")
		@CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> createEquipment(@RequestBody ManufacturingApproval manufac){
		 ManufacturingApproval equipment = manuServ.saveApproval(manufac);
			return new ResponseEntity<ManufacturingApproval>(equipment, HttpStatus.CREATED);
		}
	 


	 	@PutMapping("{id}/{rawMatId}")
		@CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> updateRawMaterials(@PathVariable Long id, @RequestBody ManufacturingApproval raw,  @PathVariable Long rawMatId){
			ManufacturingApproval rawMat = manuServ.updateManuApproval(id, rawMatId, raw);
			return new ResponseEntity<ManufacturingApproval>(rawMat, HttpStatus.CREATED);	
		}
		

		@GetMapping("{id}")
		@CrossOrigin(origins = "*", maxAge = 3600)
	
		public ResponseEntity<?> getSingleMaterial(@PathVariable Long id){
			ManufacturingApproval pr = manuServ.manuApprovalFind(id);
			return new ResponseEntity<ManufacturingApproval>(pr, HttpStatus.OK);

		}


}
