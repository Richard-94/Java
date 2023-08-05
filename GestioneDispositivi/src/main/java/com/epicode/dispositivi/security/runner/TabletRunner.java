package com.epicode.dispositivi.security.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.dispositivi.security.model.Tablet;
import com.epicode.dispositivi.security.service.TabletService;

@Component
public class TabletRunner implements CommandLineRunner {
	@Autowired TabletService tab;

	@Override
	public void run(String... args) throws Exception {
		//Tablet t = tab.createTablet("Huawei", "p-100", 100, "Huawei", "AB1235", "Vodafone");
		//Tablet t1 = tab.createTablet("Samsung", "s-1200", 150, "Android", "CS5285", "Tim");
		
		//tab.saveTablet(t1);
		
		
	}
	


}
