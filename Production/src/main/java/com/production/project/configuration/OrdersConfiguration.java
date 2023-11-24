package com.production.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.production.project.model.Equipment;
import com.production.project.model.Grinding;
import com.production.project.model.HeatTreatment;
import com.production.project.model.ManufacturingApproval;
import com.production.project.model.Paintings;
import com.production.project.model.PreliminariActivities;
import com.production.project.model.Processing;
import com.production.project.model.RawMaterials;
import com.production.project.model.Spraying;
import com.production.project.model.Springs;
import com.production.project.model.Wrapping;

@Configuration
public class OrdersConfiguration {
	@Bean("springs")
	@Scope("prototype")
	public Springs springs() {
		return new Springs();
	}
	
	@Bean("processing")
	@Scope("prototype")
	public Processing processing() {
		return new Processing();
	}
	
	@Bean("preliminari")
	@Scope("prototype")
	public PreliminariActivities preliminari() {
		return new PreliminariActivities();
	}
	
	@Bean("materials")
	@Scope("prototype")
	public RawMaterials materials() {
		return new RawMaterials();
	}
	
	@Bean("equipment")
	@Scope("prototype")
	public Equipment equipment() {
		return new Equipment();
	}
	
	@Bean("approval")
	@Scope("prototype")
	public ManufacturingApproval approval() {
		return new ManufacturingApproval();
	}
	
	@Bean("painting")
	@Scope("prototype")
	public Paintings painting() {
		return new Paintings();
	}
	
	@Bean("heating")
	@Scope("singleton")
	public HeatTreatment heating() {
		return new HeatTreatment();
	}
	
	@Bean("spraying")
	@Scope("singleton")
	public Spraying spraying() {
		return new Spraying();
	}
	
	@Bean("grinding")
	@Scope("singleton")
	public Grinding grinding() {
		return new Grinding();
	}
	
	@Bean("wrapping")
	@Scope("singleton")
	public Wrapping wrapping() {
		return new Wrapping();
	}
	

}
