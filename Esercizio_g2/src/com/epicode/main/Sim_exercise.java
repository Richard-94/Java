package com.epicode.main;

import com.eoicode.classes.Sim;

public class Sim_exercise {

	public static void main(String[] args) {
		String[] calls1 = {"call 1", "call 2", "call 3", "call 4", "call 5"};
		String[] calls2 = {"call 1", "call 2", "call 3", "call 4", "call 5"};
		
		Sim sim1 = new Sim(20, calls1, "3295788258");
		sim1.show();
		
		Sim sim2 = new Sim(10, calls2, "3335556687");
		sim2.show();
		
		
		
	}

}
