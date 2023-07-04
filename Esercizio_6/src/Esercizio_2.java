import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio_2 {
	Logger log = LoggerFactory.getLogger( Esercizio_2.class);
	
	Scanner sc = new Scanner(System.in);
	

	
	protected void calcola() {
		while(true) {
			try {
				
				System.out.print("Inserisci i km: ");
				int a = Integer.parseInt(sc.nextLine());
				if(a<0) {
					throw new MyException("Valore negativo non consentito!!!");
				}
				System.out.print("Inserisci i litri: ");
				
				int b = Integer.parseInt(sc.nextLine());
				 if(b<0) {
					throw new MyException("Valore negativo non consentito!!!");
				}
				 
				
		       double result = a / b;
		     
		        
		        log.info("Risultato:", result);
		        
		        
			}catch(ArithmeticException e) {
				log.error("Impossibile dividere per 0!!!");
				
			}catch(NumberFormatException e) {
				log.error("Caratteri non consentiti!!!");
				
			}catch (MyException e) {
				log.error(e.getMessage());
				
			} 
			
		}
		
		
	
		
	}

}
