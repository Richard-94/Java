package com.epicode.fire.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


import com.epicode.fire.interfaces.Control;

public class ControlCenter implements Control {
	private String area;
	private Long controlId;
	private FirstSensor sensor;
	
	  public ControlCenter() {
	        this.sensor = new FirstSensor();
	    }
	  public List<Sensor> information() {
		    List<Sensor> triggeredSensors = new ArrayList<Sensor>();
		    List<Sensor> sensors = sensor.createFire();
		    for (Sensor sensor : sensors) {
		        triggeredSensors.add(sensor);
		    }
		    if (!triggeredSensors.isEmpty()) {
		        System.out.println("Alarms triggered by:");
		        for (Sensor triggeredSensor : triggeredSensors) {
		            System.out.println(triggeredSensor);
		        }
		    }
		    return triggeredSensors;
		}

	@Override
	public void smoke() {
		// TODO Auto-generated method stub
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Long getControlId() {
		return controlId;
	}
	public void setControlId(Long controlId) {
		this.controlId = controlId;
	}
	
}
