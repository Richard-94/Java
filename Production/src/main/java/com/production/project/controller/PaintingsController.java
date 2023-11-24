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
import com.production.project.model.Paintings;
import com.production.project.service.EquipmentService;
import com.production.project.service.PaintingService;

@RestController
@RequestMapping("/api/production/painting")
public class PaintingsController {
	@Autowired PaintingService paintServ;
	
	 @PostMapping("/create")
		@CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> createPaintings(@RequestBody Paintings paint){
		 Paintings paintings = paintServ.savePainting(paint);
			return new ResponseEntity<Paintings>(paintings, HttpStatus.CREATED);
		}
	 
	 @PutMapping("{id}/{rawMatId}")
		@CrossOrigin(origins = "*", maxAge = 3600)
		public ResponseEntity<?> updateRawMaterials(@PathVariable Long id, @RequestBody Paintings raw,@PathVariable Long rawMatId){
		 Paintings rawMat = paintServ.updatePaint(id, raw, rawMatId);
			return new ResponseEntity<Paintings>(rawMat, HttpStatus.CREATED);	
		}
		

		@GetMapping("{id}")
		@CrossOrigin(origins = "*", maxAge = 3600)
	
		public ResponseEntity<?> getSingleMaterial(@PathVariable Long id){
			Paintings pr = paintServ.paintFind(id);
			return new ResponseEntity<Paintings>(pr, HttpStatus.OK);

		}

}
