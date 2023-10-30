package com.tesifacile.project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tesifacile.project.service.TesiService;

@Component
public class TesiRunner implements ApplicationRunner  {
	@Autowired TesiService tesiServ;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run..");
		
		//tesiServ.scheduledDeleteMessages();
		
	}

}
