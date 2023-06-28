package com.epicode.main;

import com.eoicode.classes.SimCard;

public class SimCardData {

	public static void main(String[] args) {
		SimCard sim1 = new SimCard("123456698987");
		SimCard sim2 = new SimCard("65465165");
		
		
		sim1.pushCallsInArray("987654321");
		sim2.pushCallsInArray("551118");
		
		
		sim1.datiSim();
		sim2.datiSim();		

	}

}
