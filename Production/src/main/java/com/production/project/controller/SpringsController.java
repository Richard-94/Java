package com.production.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.production.project.model.Springs;
import com.production.project.service.SpringsService;



@RestController
@RequestMapping("/api/production/springs")
public class SpringsController {
	@Autowired SpringsService springServ;
	

    @GetMapping("/all/orders")
	@CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<List<Springs>> geSprings() {
        List<Springs> springs = springServ.showAllSprings();
        ResponseEntity<List<Springs>> spring = new ResponseEntity<>(springs, HttpStatus.OK);
        return spring;
    }
    
    @GetMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<?> getSingleOrder(@PathVariable Long id){
		Springs spring = springServ.findOrder(id);
		return new ResponseEntity<Springs>(spring, HttpStatus.OK);

	}

}
