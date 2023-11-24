package com.production.project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.production.project.exception.NotNullException;
import com.production.project.repository.PreliminariActivitiesRepository;
import com.production.project.service.PreliminariActivitiesService;

@Component
public class PreliminariRunner implements ApplicationRunner {
	@Autowired PreliminariActivitiesService  preliminariServ;

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("Run..");
		try {
			//preliminariServ.saveActivities();
			
		}catch (NotNullException e) {
            System.err.println("Error: " + e.getMessage());
           
        }catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
           
        }
		
	}
	

}
