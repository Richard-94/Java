package com.eoicode.classes;

public class SimCard {
	
	public String telephoneNumber;
	public double credit;
	
	Chiamate [] callList;
	
	public SimCard(String telephoneNumber) {
		callList = new Chiamate[5]; 
		this.telephoneNumber = telephoneNumber;
		this.credit = 0;
	}
	
	public void datiSim () {
		System.out.println("**** Dati SIM ****");
		System.out.println("Numero SIM: " + this.telephoneNumber);
		System.out.println("Credito : " + this.credit);
		if(callList != null) {
			
		}
	}
	
	public void pushCallsInArray(String telephoneNumber) {
		for(int j =0; j<this.callList.length;j++) {
			if(this.callList[j] == null) {
				
				this.callList[j]=new Chiamate(telephoneNumber);
				break;
			}
		}
		
	}

}
