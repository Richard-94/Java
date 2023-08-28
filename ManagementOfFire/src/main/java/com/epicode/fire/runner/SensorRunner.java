package com.epicode.fire.runner;
import com.epicode.fire.model.Sensor;
import com.epicode.fire.model.FirstSensor;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class SensorRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(FirstSensor.class);

	@Override
	public void run(String... args) throws Exception {
//		 FirstSensor sensor1 = new FirstSensor();
//	        Sensor sensorA = new Sensor();
//	        Sensor sensorB = new Sensor();
//	        Sensor sensorC = new Sensor();
//	        
//	        sensorA.addObserver(sensor1);
//	        sensorB.addObserver(sensor1);
//	        sensorC.addObserver(sensor1);
//	        
//	        sensorA.setSmoke("ab235941-355.52", "vb5981/58555.355", 5, LocalDate.of(2023, 3, 2));
//	        sensorB.setSmoke("cd111111-444.55", "ef2222/66666.777", 1, LocalDate.of(2023, 3, 2));
//	        sensorB.setSmoke("ef256652-256.20", "ef89545/8888.727", 6, LocalDate.of(2023, 3, 2));
	}

}
