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
		
		log.info("Inserisci numero di valori: ");
		
		int a = Integer.parseInt(sc.nextLine());
		for(int i=0;i<a;i++) {
			log.info("Inserisci valore {}: ", i + 1);
			String valore = sc.nextLine();
			oggetti.add(valore);
		}
		int a1 = oggetti.size();
		
		Object[] arr = oggetti.toArray();
		for (Object e : arr) {
			if(e==valore) {
				
				log.info("Elementi duplicati: " + valore);
			}else {
				log.info("Elementi non duplicati: " + valore);
			}
		}
		
		//log.info("Size: {}", a1);

		
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
		List<Integer> randomNumber = new ArrayList<Integer>();
	    for (int number : num) {
	        randomNumber.add(number);
	    }
	    
	    List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<randomNumber.size(); i++) {
			int currentNumber = randomNumber.get(i);
			if(a) {
				if(	currentNumber%2==0) {
					 result.add(currentNumber);
				
				}
				
			}else {
				result.add(currentNumber);
			}
		}
		
		  int[] resultArray = new int[result.size()];
		    for (int i = 0; i < result.size(); i++) {
		        resultArray[i] = result.get(i);
		    }
		    log.info("even/odd: {}", resultArray);
		    return resultArray;
	}

	

	
	
	
}

