package com.epicode.dispositivi.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.dispositivi.security.model.Allocation;
import com.epicode.dispositivi.security.model.Laptop;
import com.epicode.dispositivi.security.model.Smartphone;
import com.epicode.dispositivi.security.model.Tablet;
import com.epicode.dispositivi.security.model.Worker;

@Configuration
public class GadgetsConfiguration {
	
	@Bean("smartphone")
	@Scope("prototype")
	public Smartphone smartphone() {
		return new Smartphone();
	}
	
	@Bean("tablet")
	@Scope("prototype")
	public Tablet tablet() {
		return new Tablet();
	}
	
	@Bean("laptop")
	@Scope("prototype")
	public Laptop laptop() {
		return new Laptop();
	}
	
	@Bean("allocation")
	@Scope("prototype")
	public Allocation allocation() {
		return new Allocation();
	}
	
	
	@Bean("worker")
	@Scope("prototype")
	public Worker worker() {
		return new Worker();
	}

}
