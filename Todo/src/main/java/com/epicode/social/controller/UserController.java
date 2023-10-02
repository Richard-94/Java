package com.epicode.social.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.social.model.UserApp;
import com.epicode.social.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/todos")
public class UserController {
	@Autowired UserService userServ;
	
	

	@GetMapping
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<List<UserApp>> getUsers(){
		List<UserApp> users = userServ.getAllUser();
		ResponseEntity<List<UserApp>>u = new ResponseEntity <List<UserApp>>(users, HttpStatus.OK);
		return u;
	}
	
	@PostMapping
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<?> createWorker(@RequestBody UserApp wo){
		UserApp ws = userServ.saveUser(wo);
		return new ResponseEntity<UserApp>(ws, HttpStatus.CREATED);

	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<?> getSingleWorker(@PathVariable Long id){
		UserApp pr = userServ.userFind(id);
		return new ResponseEntity<UserApp>(pr, HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> delWorker(@PathVariable Long id){
		ResponseEntity<String> msg = userServ.workerDel(id);
		return new ResponseEntity<String>(HttpStatus.OK);

	}
	

}
