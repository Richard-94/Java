package com.epicode.dispositivi.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/worker")
public class WorkerController {
	@Autowired WorkerService w;
	

	@GetMapping
	public ResponseEntity<List<Worker>> getWorkers(){
		List<Worker> users = w.getAllWorkers();
		ResponseEntity<List<Worker>>u = new ResponseEntity <List<Worker>>(users, HttpStatus.OK);
		return u;

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getSingleUser(@PathVariable Long id){
		Worker pr = w.workerFind(id);
		return new ResponseEntity<Worker>(pr, HttpStatus.OK);

	}
	
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody Worker wo){
		Worker ws = w.saveWorker(wo);
		return new ResponseEntity<Worker>(ws, HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Worker u){
		Worker u1 = w.updateWorker(id, u);
		return new ResponseEntity<Worker>(u1, HttpStatus.CREATED);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delUser(@PathVariable Long id){
		String msg = w.workerDel(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

}
