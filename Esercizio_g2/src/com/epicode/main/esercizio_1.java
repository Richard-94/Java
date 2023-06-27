package com.epicode.main;

import com.eoicode.classes.Esercizio1_class;

public class esercizio_1 {

	public static void main(String[] args) {
		Esercizio1_class area1 = new Esercizio1_class(5,6);
		Esercizio1_class area2 = new Esercizio1_class(30,5);
		
		int resultArea1 = area1.area(area1.base, area1.altezza);
		int resultArea2 = area2.area(area2.base, area2.altezza);
		int firstCaseArea = resultArea1+resultArea2;
		
		
		
		int resultPerimeter1 = area1.perimeter(area1.base, area1.altezza);
		int resultPerimeter2 = area2.perimeter(area2.base, area2.altezza);
		int firstCasePerimeter =  resultPerimeter1+ resultPerimeter2;
		
		
		
		
		System.out.println("Area 1: " + resultArea1);
		System.out.println("Area 2: " + resultArea2);
		
		System.out.println("Perimeter1: " + resultPerimeter1);
		System.out.println("Perimeter2: " + resultPerimeter2);
		
		System.out.println("Sum of two Areas: " + firstCaseArea);
		System.out.println("Sum of two Perimeters: " + firstCasePerimeter);
		
		
		

	}

}
