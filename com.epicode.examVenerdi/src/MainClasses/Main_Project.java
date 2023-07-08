package MainClasses;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.LoggerFactory;





public class Main_Project {
	static Scanner sc = new Scanner(System.in);
	static org.slf4j.Logger log = LoggerFactory.getLogger(Main_Project.class);
	 static int currentYear = LocalDate.now().getYear();

	public static void main(String[] args) {
		Set<Catalogo> contenuto = new HashSet<Catalogo>();
		
		
	     log.info("Current date: " + currentYear);
	 	//log.info("che cosa vuoi creare?: ");
		//while(true) {
			
			//int choose = sc.nextInt();
			
			//switch(choose) {
			
			//case 0:
				//log.info("uscita dal programma");
				//return;
			
			
			//case 1:
				///creatRivisti(contenuto);
				//break;
				
			//case 2:
				//creatLibri(contenuto);
				//break;
				
				//default:
					//log.info("valore deve essere tra 1-2");
					
					//log.info("che cosa vuoi creare?: ");
			//}
			
		//}
	 	
	 	creatRivisti(contenuto);
	 	creatLibri(contenuto);
	 	//log.info("vuoi rimuovere un isbn?");
	 	//removeByIsbn(contenuto);
	 	log.info("vuoi cercare un isbn?");
	 	//searchByIsbn(contenuto);
	 	log.info("vuoi cercare un anno?");
	 	searchByYear(contenuto);
	}
		
	
	private static void creatRivisti(Set<Catalogo> contenuto)  {

			int numero;
			log.info("Rivisti invocato");
			log.info("Quanti Rivisti vuoi inserire: ");
			int num = 0;

			try {
			 numero = sc.nextInt();
			 if(numero<0) {
				 throw new IllegalArgumentException("invalid number");
			 }
			
			for(int i = 0; i<numero;i++) {
				log.info("Crea Revista numero: " + ++num);
				log.info("Inserisci codice: ");
				String isbn = sc.next();
				sc.nextLine(); 
				log.info("Inserisci Titolo: ");
				String titolo = sc.next();
				log.info("Anno pubblicazione: ");
				int anno = sc.nextInt();
				if(anno>currentYear ) {
					throw new DateTimeException("invalid year");
				}
				else if(anno<1000) {
					throw new HandleError("Anno non puo essere minore di 1000");
				}
				sc.nextLine(); 
				log.info("Inserisci Pagine: ");
				int pag = sc.nextInt();
				if(pag<0) {
					throw new IllegalArgumentException("invalid number");
				}
				log.info("Scegli periodo: ");
				for (Period period : Period.values()) {
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
				Riviste mag = new Riviste(isbn,titolo,anno,pag, periodoScelto);
				contenuto.add(mag);
				
			}
			for (Catalogo catalogo : contenuto) {
				log.info("Elementi: " + catalogo);
			}
			
			
			log.info("Vuoi Creare anche Libri?");
			
	
		}catch (DateTimeException e) {
			log.error("Anno deve esseres minore o uguale all'anno corrente ");
		} catch (HandleError e) {
			log.error(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			log.error("Il numero deve essere positivo");
		}
	}
	
	private static void creatLibri(Set<Catalogo> contenuto) {
		log.info("Libri invocato");
		int numero;
		
		log.info("Quanti Libri vuoi inserire: ");
		int num = 0;

		try {
		 numero = sc.nextInt();
		 if(numero<0) {
			 throw new IllegalArgumentException("invalid number");
		 }
		
		for(int i = 0; i<numero;i++) {
			log.info("Crea Revista numero: " + ++num);
			log.info("Inserisci codice: ");
			String isbn = sc.next();
			sc.nextLine(); 
			log.info("Inserisci Titolo: ");
			String titolo = sc.next();
			log.info("Anno pubblicazione: ");
			int anno = sc.nextInt();
			if(anno>currentYear ) {
				throw new DateTimeException("invalid year");
			}
			else if(anno<1000) {
				throw new HandleError("Anno non puo essere minore di 1000");
			}
			sc.nextLine(); 
			log.info("Inserisci Pagine: ");
			int pag = sc.nextInt();
			if(pag<0) {
				throw new IllegalArgumentException("invalid number");
			}
			sc.nextLine(); 
			log.info("Inserisci Autore: ");
			String aut = sc.next();
			sc.nextLine(); 
			log.info("Inserisci Genere: ");
			String gen = sc.next();
			

			Libri book = new Libri(isbn, titolo, anno, pag, aut,gen);
			contenuto.add(book);
			
		}
		for (Catalogo catalogo : contenuto) {
			log.info("Elementi: " + catalogo);
		}
		
	
		
		}catch (DateTimeException e) {
			log.error("Anno deve esseres minore o uguale all'anno corrente ");
		} catch (HandleError e) {
			log.error(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			log.error("Il numero deve essere positivo");
		}
		
		
	}
	
	
	
	public static void removeByIsbn(Set<Catalogo> contenuto) {
		log.info("Inserisci codice: ");
		String isbn = sc.next();
		contenuto.removeIf(catalogo->catalogo.getISBN().equals(isbn));
		for (Catalogo catalogo : contenuto) {
			log.info("Elementi: " + catalogo);
		}
	}
	
	
	public static void searchByIsbn(Set<Catalogo> contenuto) {
		log.info("Inserisci codice: ");
		String isbn = sc.next();
		 List<Catalogo> search = contenuto.stream()
				 .filter(el->el.getISBN().equals(isbn))
				 .collect(Collectors.toList()); 
		
		search.forEach(show -> log.info("Catalogo: {}", show));
		
	}
	
	public static void searchByYear(Set<Catalogo> contenuto) {
		log.info("Inserisci Anno: ");
		int data = sc.nextInt();
		 List<Catalogo> date = contenuto.stream()
				 .filter(el->el.getAnno_pubblicazione()==data)
				 .collect(Collectors.toList());
		
		date.forEach(show -> log.info("Catalogo: {}", show));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
