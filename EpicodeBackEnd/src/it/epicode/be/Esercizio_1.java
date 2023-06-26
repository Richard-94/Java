package it.epicode.be;

import java.util.Arrays;
import java.util.Scanner;

public class Esercizio_1 {
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		System.out.println(multiply(5,6));
		
		System.out.println(concat("ciao ",6));
		 
		String [] a = {"hey", "ciao", "come", "stai", "tu"};
		String b = "Pace";
		 String[] modifiedArray = arrayString(a, b);
		System.out.println(Arrays.toString(modifiedArray));
		
		System.out.println (perimeter(5, 6));
		
		System.out.println (even(7));
		
		System.out.println (area(7,5));
		
		
		
		
		accept();
		
		
	}
	
	

	
	public static int multiply (int a, int b) {
		return a *b;
	}
	
	
	
	public static String concat(String a, int b) {
		return a +b;
	}
	
	
	
	public static String[] arrayString(String []a, String b) {
		if(a.length==5) {
			String[] newArray = new String[6];
			for(int i = 0; i<a.length; i++) {
				newArray[i]= a[i];
			}
			newArray[3] = b;
	        return newArray;
		}else {
			return a;
		}
	}
	
  



	public static void accept() {
	System.out.print("Insert name");
	String nome = sc.nextLine();	
	
	System.out.print("Insert surname: ");
	String cognome = sc.nextLine();	
	
	System.out.print("Insert city:");
	String city = sc.nextLine();	
	
	System.out.println(nome + cognome + city);
	System.out.println(city + cognome + nome);
	}



	public static double perimeter(double num1, double num2) {
		return 2*(num1+num2);
	}
	
	public static int even(int num) {
		if(num%2==0) {
			return 0;
		}else {
			return 1;
		}
	}
	

	public static double area(double num1, double num2) {
		return (num1*num2)/2;
	}

}





