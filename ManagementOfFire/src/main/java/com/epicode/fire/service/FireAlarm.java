package com.epicode.fire.service;

import java.util.List;

import com.epicode.fire.model.Sensor;

public class FireAlarm {
	  public static boolean createFireAlarm(List<Sensor> sensors) {
	        int totalSmokeQuantity = 0;

	        for (Sensor sensor : sensors) {
	            totalSmokeQuantity += sensor.getSmokeQuantity();
	        }

	        if (totalSmokeQuantity > 2) {
	            return true; // Fire alarm condition is met
	        }

	        return false; // No fire alarm condition
	    }

}
