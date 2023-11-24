package com.production.project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.production.project.exception.NotNullException;
import com.production.project.service.SprayingService;
import com.production.project.service.WrappingService;

@Component
public class SprayingRunner implements ApplicationRunner {
	@Autowired SprayingService  sprayServ;

	@Override
	public void run(ApplicationArguments args) {
		try {
			//sprayServ.createSpraying();
			
		}catch (NotNullException e) {
            System.err.println("Error: " + e.getMessage());
           
        }
		
		
	}

}
