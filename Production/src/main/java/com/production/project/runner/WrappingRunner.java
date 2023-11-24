package com.production.project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.production.project.exception.NotNullException;
import com.production.project.service.WrappingService;

@Component
public class WrappingRunner implements ApplicationRunner {
	@Autowired WrappingService  wrapServ;

	@Override
	public void run(ApplicationArguments args) {
		try {
			//wrapServ.createWrapping();
			
		}catch (NotNullException e) {
            System.err.println("Error: " + e.getMessage());
           
        }
		
		
	}

}
