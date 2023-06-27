package com.eoicode.classes;

public class Sim {
	public int credit = 50;
	public int duration;
	public String [] calls;
	public String phoneNumber;
	
	
	public Sim(int duration,  String [] calls, String phoneNumber) {
		this.credit = credit;
		this.duration = duration;
		this.calls= calls;
		this.phoneNumber = phoneNumber;
		
	}
	
	public  void show() {
		 System.out.println("your Phone Number is  " + phoneNumber);
        System.out.println("Your Credit is " + credit);
        System.out.println("Call duration is " + duration);
        //System.out.println("total number of calls " + calls);
        for (String call : calls) {
            System.out.println(call);
        }
        
    }

}
