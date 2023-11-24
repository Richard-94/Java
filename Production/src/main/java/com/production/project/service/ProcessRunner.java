package com.production.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.production.project.exception.NotNullException;

@Component
public class ProcessRunner implements ApplicationRunner {
	@Autowired ProcessingService  processServ;

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("Run..");
		try {
			//processServ.saveProcess();;
			
		}catch (NotNullException e) {
            System.err.println("Error: " + e.getMessage());
           
        }catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
           
        }
		
	}

}
