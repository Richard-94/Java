package com.epicode.prenotazione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epicode.prenotazione.model.Prenotation;
import com.epicode.prenotazione.model.User;
import com.epicode.prenotazione.service.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController {
	@Autowired UserService us;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = us.getAllUsers();
		ResponseEntity<List<User>>u = new ResponseEntity <List<User>>(users, HttpStatus.OK);
		return u;

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getSingleUser(@PathVariable Long id){
		User pr = us.userFind(id);
		return new ResponseEntity<User>(pr, HttpStatus.OK);

	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User u){
		User pr = us.saveUser(u);
		return new ResponseEntity<User>(pr, HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User u){
		User u1 = us.updateUser(id, u);
		return new ResponseEntity<User>(u1, HttpStatus.CREATED);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delUser(@PathVariable Long id){
		String msg = us.userdel(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}
	
	

}
