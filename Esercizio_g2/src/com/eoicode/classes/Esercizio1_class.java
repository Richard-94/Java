package com.eoicode.classes;

public class Esercizio1_class {
	public int base;
	public int altezza;
	
	
	
	public  Esercizio1_class (int base, int altezza) {
		this.base = base;
		this.altezza = altezza;
	}
	
	public static int area(int base, int altezza) {
		return base*altezza;
	}
	
	public static int perimeter(int base, int altezza) {
		return 2*(base+altezza);
	}
	
	

}
