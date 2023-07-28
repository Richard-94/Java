package com.epicode.prenotazione.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class BookingRunner implements CommandLineRunner {
	Logger log = LoggerFactory.getLogger(BookingRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Run...");
		
	}

}
