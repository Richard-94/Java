package com.epicode.dispositivi.security.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.dispositivi.security.model.Laptop;
import com.epicode.dispositivi.security.service.LaptopService;

@Component
public class LaptopRunner implements CommandLineRunner {
	@Autowired LaptopService lab;

	@Override
	public void run(String... args) throws Exception {
		//Laptop l = lab.createLaptop("Saamsung", "VF-531", 500, "Windows", "SD125", 5);
		//Laptop l = lab.createLaptop("HP", "JU-253", 200, "Linux", "NJ365", 3);
		//lab.saveLaptop(l);
		
	}

}
