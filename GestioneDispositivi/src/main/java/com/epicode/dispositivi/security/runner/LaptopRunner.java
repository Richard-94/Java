package com.epicode.dispositivi.security.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.model.Laptop;
import com.epicode.dispositivi.security.service.LaptopService;

@Component
public class LaptopRunner implements CommandLineRunner {
	@Autowired LaptopService lab;

	@Override
	public void run(String... args) throws Exception {
//		LocalDate customDate = LocalDate.of(2023, 2, 12);
//		Laptop newLaptop =lab.createLaptop("Samsung", "JL235", Status.MAINTENANCE, 8, "OS", "ISBN235", 2, customDate);
//		LocalDate customDate = LocalDate.of(2023, 2, 12);
//		Laptop newLaptop = lab.createLaptop("Dell", "XPS15", Status.AVAILABLE, 16, "Windows", "ISBN789", 3, customDate);
//
////
//		try {
//			lab.saveLaptop(newLaptop);
//		} catch (IllegalArgumentException e) {
//            System.err.println("Error: " + e.getMessage());
//	           
//        }
		
		
	}

}
