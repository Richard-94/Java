package com.epicode.dispositivi.security.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.model.Smartphone;
import com.epicode.dispositivi.security.service.SmartphoneService;

@Component
public class SmartphoneRunner implements CommandLineRunner {
	@Autowired SmartphoneService sm;

	@Override
	public void run(String... args) throws Exception {
//		LocalDate customDate = LocalDate.of(2023, 8, 17);
//
//		Smartphone newSmartphone = sm.createSmartphone("Nokia","3310",Status.AVAILABLE,1024,"Symbian","Vd235",1,"Flute",customDate);
//
		LocalDate customDate = LocalDate.of(2022, 3, 10);

Smartphone newSmartphone = sm.createSmartphone("Samsung","Galaxy S21",Status.MAINTENANCE,4096,"Android","Sa456",2,"Clarinet",customDate);



		try {
			sm.saveSmartphone(newSmartphone);
		}catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
          
        }
		
		
		
	}

}
