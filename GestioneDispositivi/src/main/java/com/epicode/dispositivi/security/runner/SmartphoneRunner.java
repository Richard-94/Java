package com.epicode.dispositivi.security.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.dispositivi.security.model.Smartphone;
import com.epicode.dispositivi.security.service.SmartphoneService;

@Component
public class SmartphoneRunner implements CommandLineRunner {
	@Autowired SmartphoneService sm;

	@Override
	public void run(String... args) throws Exception {
		//Smartphone s = sm.createSmartphone("Nokia", "3310", 1024, "Symbian", "Vd235", 1, "Flute");
		//Smartphone s = sm.createSmartphone("Nokia", "Lumia", 64, "Nokia", "XC166", 2, "cool");
		//sm.saveSmartphone(s);
		
		
	}

}
