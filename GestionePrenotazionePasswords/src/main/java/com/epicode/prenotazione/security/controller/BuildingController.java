package com.epicode.prenotazione.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epicode.prenotazione.security.model.Building;

import com.epicode.prenotazione.security.service.BuildingService;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/buildings")
public class BuildingController {
	@Autowired BuildingService bl;
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Building>> getUsers(){
		List<Building> users = bl.printaAllLocation();
		ResponseEntity<List<Building>>u = new ResponseEntity <List<Building>>(users, HttpStatus.OK);
		return u;

	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> getSingleUser(@PathVariable Long id){
		Building  pr = bl.userFind(id);
		return new ResponseEntity<Building >(pr, HttpStatus.OK);

	}
	
	@PostMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> createUser(@RequestBody Building u){
		Building pr = bl.saveBuilding(u);;
		return new ResponseEntity<Building>(pr, HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Building u){
		Building  u1 = bl.updateBuilding(id, u);
		return new ResponseEntity<Building >(u1, HttpStatus.CREATED);	
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> delUser(@PathVariable Long id){
		String msg = bl.buildingdel(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}
	
	


}
