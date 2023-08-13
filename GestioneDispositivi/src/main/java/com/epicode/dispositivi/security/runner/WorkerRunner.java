package com.epicode.dispositivi.security.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.epicode.dispositivi.security.model.Worker;
import com.epicode.dispositivi.security.service.WorkerService;

@Configuration
public class WorkerRunner implements CommandLineRunner {
	@Autowired WorkerService ws;

	@Override
	public void run(String... args) throws Exception {
		//Worker w = ws.createWorker("Manuel", "Lomb", "mclom", "ma.lom@gmail.com");
		Worker w = ws.createWorker("Angela", "Mordichio", "angie.1", "an.morb@example.com");
		ws.saveWorker(w);
	}

}
