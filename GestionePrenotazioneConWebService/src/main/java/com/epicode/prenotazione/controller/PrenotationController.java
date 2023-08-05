package com.epicode.prenotazione.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epicode.prenotazione.model.Prenotation;
import com.epicode.prenotazione.model.User;
import com.epicode.prenotazione.service.PrenotationService;
import com.epicode.prenotazione.service.UserService;

@Controller
@RequestMapping("/api/users")
public class PrenotationController {
	@Autowired PrenotationService p;

	
	
	@GetMapping("/english")
	public @ResponseBody String english() {
		return "Hello and welcome to the prenotation site";
	}
	
	@GetMapping("/italian")
	public @ResponseBody String italian() {
		return "Buongiorno e benvenuti sul sito di prenotazione";
	}
	
	
	
	@GetMapping("/prenotations")
	public ResponseEntity<List<Prenotation>> getAllPrenotations(){
		List<Prenotation> pr = p.book();
		ResponseEntity<List<Prenotation>> po = new ResponseEntity <List<Prenotation>>(pr, HttpStatus.OK);
		return po;
	}
	
	@GetMapping("/prenotations/{id}")
	public ResponseEntity<Prenotation> getSingleBooking(@PathVariable Long id){
		Prenotation pr = p.findSingleBooking(id);
		return new ResponseEntity<Prenotation>(pr, HttpStatus.OK);

	}
	
	

}
