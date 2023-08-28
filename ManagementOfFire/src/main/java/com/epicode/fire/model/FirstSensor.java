package com.epicode.fire.model;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class FirstSensor implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(FirstSensor.class);

	private String latitude;
	private String longitude;
	private String area;
	private int smokeQuantity;
	private LocalDateTime date;
	

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Sensor) {
			Sensor sensor1 = (Sensor) o;
			this.latitude = sensor1.getLatitude();
			this.longitude = sensor1.getLongitude();
			this.smokeQuantity = sensor1.getSmokeQuantity();
			this.date = sensor1.getDate();
			this.area = sensor1.getArea();
			
		}
		
	}

	private void noAllarm() {
		System.out.println("no allarm rilieved");
		
	}
	
	public void startAllarm() {
        System.out.println("A Fire Allarm has been triggered");

    }

	public void AllarmAddress() {
        System.out.println("Latitude address: " + latitude + 
                           " Longitude address: " + longitude + 
                           " date: " + date + " The smoke quantity is: " + smokeQuantity);

    }
	
	public List<Sensor> createFire() {
	    List<Sensor> trigger = new ArrayList<Sensor>();

	    Sensor sensorA = new Sensor();
	    Sensor sensorB = new Sensor();
	    Sensor sensorC = new Sensor();

	    sensorA.setSmoke("ab235941-355.52", "vb5981/58555.355", 10, LocalDateTime.now(), "industrial-area");
	    if (sensorA.getSmokeQuantity() >= 5) {
	        startAllarm();
	        trigger.add(sensorA);
	    }

//	    sensorB.setSmoke("cd111111-444.55", "ef2222/66666.777", 16, LocalDateTime.now(), "City-center");
//	    if (sensorB.getSmokeQuantity() >= 5) {
//	        startAllarm();
//	        trigger.add(sensorB);
//	    }
//
//	    sensorC.setSmoke("ef256652-256.20", "ef89545/8888.727", 6, LocalDateTime.now(), "Market");
//	    if (sensorC.getSmokeQuantity() >= 5) {
//	        startAllarm();
//	        trigger.add(sensorC);
//	    }
	    else {
	    	noAllarm();
	    }
	    return trigger;
	}



}