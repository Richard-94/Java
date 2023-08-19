package com.epicode.dispositivi.security.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.model.Tablet;
import com.epicode.dispositivi.security.service.TabletService;

@Component
public class TabletRunner implements CommandLineRunner {
	@Autowired TabletService tab;

	@Override
	public void run(String... args) throws Exception {
		//LocalDate customDate = LocalDate.of(2023, 2, 12);
		//Tablet t =tab.createTablet("Samsung", "KL895", Status.RETIRED, 64, "Android", "ISBN365", "Vodafone", customDate);
		
//		LocalDate customDate2 = LocalDate.of(2022, 7, 15);
//		Tablet t2 = tab.createTablet("Apple", "iPad Pro", Status.AVAILABLE, 256, "iOS", "ISBN879", "AT&T", customDate2);
//
//		
//		
//		 try {
//	            tab.saveTablet(t2);
//	        } catch (IllegalArgumentException e) {
//	            System.err.println("Error: " + e.getMessage());
//	           
//	        }
		
		
	}
	


}
