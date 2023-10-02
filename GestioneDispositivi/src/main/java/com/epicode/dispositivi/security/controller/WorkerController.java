package com.epicode.dispositivi.security.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.dispositivi.security.model.Worker;
import com.epicode.dispositivi.security.service.WorkerService;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/worker")
public class WorkerController {
	@Autowired WorkerService w;
	

	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<Worker>> getWorkers(){
		List<Worker> users = w.getAllWorkers();
		ResponseEntity<List<Worker>>u = new ResponseEntity <List<Worker>>(users, HttpStatus.OK);
		return u;

	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> getSingleWorker(@PathVariable Long id){
		Worker pr = w.workerFind(id);
		return new ResponseEntity<Worker>(pr, HttpStatus.OK);

	}
	
	
	@PostMapping
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<?> createWorker(@RequestBody Worker wo){
		Worker ws = w.saveWorker(wo);
		return new ResponseEntity<Worker>(ws, HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	
	public ResponseEntity<?> updateWorker(@PathVariable Long id, @RequestBody Worker u){
		Worker u1 = w.updateWorker(id, u);
		return new ResponseEntity<Worker>(u1, HttpStatus.CREATED);	
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> delWorker(@PathVariable Long id){
		ResponseEntity<String> msg = w.workerDel(id);
		return new ResponseEntity<String>(HttpStatus.OK);

	}

}
