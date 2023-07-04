import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio_1 {
	static Scanner sc = new Scanner(System.in);
	
	private static Logger log = LoggerFactory.getLogger(Esercizio_1.class);
	static String valore = "";
	
	
	public static void test() {
		Set<String> oggetti = new HashSet<String>();
		Set<String> diversi = new HashSet<String>();
		
		log.info("Inserisci numero di valori: ");
		
		int a = Integer.parseInt(sc.nextLine());
		for(int i=0;i<a;i++) {
			log.info("Inserisci valore {}: ", i + 1);
			String valore = sc.nextLine();
			if(!oggetti.add(valore))
			diversi.add(valore);
		}
		int a1 = oggetti.size();
		int a2=diversi.size();
		
		for(String valore:oggetti) {
			log.info(valore);
		}
		
		for(String valore:diversi) {
			log.info("valore duplicate:" + valore);
		}
		
		
		log.info("duplicate: {}", a1);
		log.info("non duplicate: {}", a2);

		
	}
	
	
	public static int[] Random() {
		java.util.Random random = new java.util.Random();
		log.info("Inserisci numero di valore: ");
		int a1 = Integer.parseInt(sc.nextLine());
		int[] randomNumber = new int[a1];
		for(int i = 0;i<randomNumber.length;i++) {
			 randomNumber[i] = random.nextInt(101);	
		}
		log.info("Random numbers: {}",  randomNumber);
		return randomNumber;

	}
	
	public static void Invert(int[] numbers) {
	    List<Integer> randomNumber = new ArrayList<Integer>();
	    for (int number : numbers) {
	        randomNumber.add(number);
	    }
	    Collections.reverse(randomNumber);
	    log.info("Inverted numbers: {}", randomNumber);
	}
	
	
	
	public static int[] bool(int[] num, boolean a) {
		List<Integer> randomEven = new ArrayList<Integer>();
		List<Integer> randomOdd= new ArrayList<Integer>();
	    for (int i=0;i<num.length;i++) {
	    	if(i%2==0) {
	    		randomEven.add(num[i]);
	    		
	    	}else {
	    		randomOdd.add(num[i]);
	    	}
	    }
	    
	    for(int num1: randomEven) {
			log.info("even index:" + num1);
		}
	    
	    for(int num2: randomOdd) {
			log.info("odd index:" + num2);
		}
		return num;
	    
	   
	}

	

	
	
	
}

