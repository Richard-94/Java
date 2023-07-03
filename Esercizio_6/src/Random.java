
import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Random {
	
	public void randomNumber() {
		Scanner sc = new Scanner(System.in);
		
		Logger log = LoggerFactory.getLogger(Random.class);
		
		
		while(true) {
			java.util.Random random = new java.util.Random();
			int[] randomNumber = new int[5];
			int uscita = 0;

			
				try {
					for(int i = 0;i<randomNumber.length;i++) {
							 randomNumber[i] = random.nextInt(9)+1;	
					}

					log.info("Random numbers: {}",  randomNumber);

					log.info("Inserire un numero alla posizione 3");
					
					int scelta = Integer.parseInt(sc.nextLine());
					if(scelta == uscita) {
						log.info("Fine");
						break;
					}
					
					randomNumber[4]=scelta;
					
					
					log.info("Random numbers: {}",  randomNumber);
					
				} catch(ArrayIndexOutOfBoundsException e) {
					log.error("Posizione non accettabile!!!");
					
				}catch(NumberFormatException e) {
					log.error("Caratteri non consentiti!!!");
					
				}
				
	
		}
		 
	}

	
}
