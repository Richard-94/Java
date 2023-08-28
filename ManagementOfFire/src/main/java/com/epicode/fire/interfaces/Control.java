package com.epicode.fire.interfaces;

import java.util.List;
import java.util.Set;

import com.epicode.fire.model.FirstSensor;
import com.epicode.fire.model.Sensor;

public interface Control{
	
	public List<Sensor> information();
	public void smoke();
	
}
