package com.epicode.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.api.model.Contacts;
import com.epicode.api.service.ContactsService;

@RestController
@RequestMapping("/api/contacts")
public class ContactsControl {
	
	@Autowired ContactsService u;
	@GetMapping
	public ResponseEntity<List<Contacts>> getAll(){
		List<Contacts> c = u.fetchAll();
		ResponseEntity<List<Contacts>> co = new ResponseEntity<List<Contacts>> (c, HttpStatus.OK);
		return co;
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		try {
			Contacts c = u.fetchOneUser(id);
			return new ResponseEntity<Contacts>(c, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> createContact(@RequestBody Contacts cont) {
		try {
			Contacts c = u.saveContacts(cont);
			return new ResponseEntity<Contacts>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
