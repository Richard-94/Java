package com.epicode.fireapp.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class SenseRunner implements CommandLineRunner {
	 Logger logger = LoggerFactory.getLogger(SenseRunner.class);
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Run........");
	}

}
