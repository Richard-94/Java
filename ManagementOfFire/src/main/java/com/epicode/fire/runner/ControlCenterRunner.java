package com.epicode.fire.runner;

import org.springframework.boot.CommandLineRunner;
import com.epicode.fire.model.ControlCenter;

import org.springframework.stereotype.Component;

@Component
public class ControlCenterRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		ControlCenter c = new ControlCenter();
		//c.prepare();
		c.information();
		
	}

}
