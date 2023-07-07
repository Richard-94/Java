package MainClasses;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


import org.slf4j.LoggerFactory;





public class Main_Project {
	static Scanner sc = new Scanner(System.in);
	static org.slf4j.Logger log = LoggerFactory.getLogger(Main_Project.class);
	

	public static void main(String[] args) {
		Set<Catalogo> contenuto = new HashSet<Catalogo>();
		
		
		
		log.info("che cosa vuoi creare?: ");
		int choose = sc.nextInt();
		
		switch(choose) {
			case 1:
				creatRivisti(contenuto);
				break;
			
			case 2:
				creatLibri(contenuto);
				break;
			}
		
			if(choose>2) {
				log.info("Valore deve essere compreso tra 1-2");
			}

		}
		

	
	private static void creatRivisti(Set<Catalogo> contenuto) {
		log.info("Rivisti invocato");
		log.info("Quanti Rivisti vuoi inserire: ");
		int num = 0;
		int numero = sc.nextInt();
		for(int i = 0; i<numero;i++) {
			log.info("Crea numero: " + ++num);
			log.info("Inserisci codice: ");
			String isbn = sc.next();
			log.info("Inserisci titolo: ");
			String titolo = sc.next();
			log.info("Anno pubblicazione: ");
			int anno = sc.nextInt();
			log.info("Inserisci Pagine: ");
			int pag = sc.nextInt();
			log.info("Scegli periodo: ");
			for(Period period:Period.values()) {
				log.info("" + period);
			}
			
			int scegli=sc.nextInt();
			 Period periodoScelto = null;
			switch(scegli) {
				case 0:
					periodoScelto = Period.MENSILE;
					break;
				case 1:
					periodoScelto = Period.SEMESTRALE;
				break;
				
				case 2:
					periodoScelto = Period.SETTIMANALE;
				break;
					
			}
			Riviste mag = new Riviste(isbn, titolo,anno,pag, periodoScelto);
			contenuto.add(mag);
				
		}
		 for (Catalogo catalogo : contenuto) {
		        log.info("Element: " + catalogo);
		    }
	
	}
	
	private static void creatLibri(Set<Catalogo> contenuto) {
		log.info("Libri invocato");
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
