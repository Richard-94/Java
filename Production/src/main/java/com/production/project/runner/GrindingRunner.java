package com.production.project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.production.project.exception.NotNullException;
import com.production.project.service.GrindingService;


@Component
public class GrindingRunner implements ApplicationRunner {
	@Autowired GrindingService  grindServ;

	@Override
	public void run(ApplicationArguments args) {
		try {
			grindServ.createGrinding();
			
		}catch (NotNullException e) {
            System.err.println("Error: " + e.getMessage());
           
        }
		
		
	}
	

}
