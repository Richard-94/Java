package com.production.project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.production.project.exception.NotNullException;
import com.production.project.service.HeatTreatmentService;
import com.production.project.service.WrappingService;

@Component
public class HeatTreatmentRunner implements ApplicationRunner {
	@Autowired HeatTreatmentService  heatServ;

	@Override
	public void run(ApplicationArguments args) {
			try {
				//heatServ.createHeatTreatment();
			}catch (NotNullException e) {
	            System.err.println("Error: " + e.getMessage());
	        }
		}
}
