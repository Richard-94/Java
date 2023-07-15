package MainClasses;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;


public class Main_Project {
	static Scanner sc = new Scanner(System.in);
	static org.slf4j.Logger log = LoggerFactory.getLogger(Main_Project.class);
	 static int currentYear = LocalDate.now().getYear();
	 private static File file = new File("documenti/catalogo.txt");

	public static void main(String[] args) {
		Set<Catalogo> contenuto = new HashSet<Catalogo>();
		
		
		
	     //log.info("Current date: " + currentYear);
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
	 	log.info("vuoi rimuovere un isbn?");
	 	removeByIsbn(contenuto);
	 	log.info("vuoi cercare un isbn?");
	 	searchByIsbn(contenuto);
	 	log.info("vuoi cercare un anno?");
	 	searchByYear(contenuto);
	 	log.info("vuoi cercare un autore?");
	 	searchByAuthor(contenuto);
	 	salvaDati(contenuto);
	 	contenuto = caricaFile();

	}
		
	
	private static void creatRivisti(Set<Catalogo> contenuto)  {
			int numero;
			log.info("QUANTI RIVISTE VUOI INSERIRE?: ");
			int num = 0;

			try {
			 numero = sc.nextInt();
			 if(numero<0) {
				 throw new IllegalArgumentException("NUMERO INVALIDO");
			 }
			
			for(int i = 0; i<numero;i++) {
				log.info("Crea Revista numero: " + ++num);
				log.info("Inserisci codice: ");
				String isbn = sc.next();
				sc.nextLine(); 
				log.info("Inserisci Titolo: ");
				String titolo = sc.nextLine();

				log.info("Anno pubblicazione: ");
				int anno = sc.nextInt();
				if(anno>currentYear ) {
					throw new DateTimeException("ANNO INVALIDO");
				}
				else if(anno<1000) {
					throw new HandleError("L'ANNO NON PUO' ESSERE MINORE DI 1000");
				}
				sc.nextLine(); 
				log.info("Inserisci Pagine: ");
				int pag = sc.nextInt();
				if(pag<0) {
					throw new IllegalArgumentException("NUMERO INVALIDOS");
				}
				log.info("Scegli 0:MENSILE, 1:SEMESTRALE:, 2:SETTIMANALE ");
				for (Period period : Period.values()) {
					log.info("" + period);
				}
	
				int scegli=sc.nextInt();
				if(scegli>2) {
					log.info("LE OPZIONI VANNO DA  0 - 2");
				}
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
			log.error("L'ANNO DEVE ESSERE MINORE O UGUALE ALL'ANNO CORRENTE");
		} catch (HandleError e) {
			log.error(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			log.error("SOLO NUMERI POSITIVI");
		}catch (InputMismatchException e) {
			log.error("SOLO NUMERI SONO CONSENTITI");
		}
		
	}
	
	private static void creatLibri(Set<Catalogo> contenuto) {
		log.info("Libri invocato");
		int numero;
		
		log.info("QUANTI LIBRI VUOI INSERIRE: ");
		int num = 0;

		try {
		 numero = sc.nextInt();
		 if(numero<0) {
			 throw new IllegalArgumentException("NUMERO INVALIDO");
		 }
		
		for(int i = 0; i<numero;i++) {
			log.info("Crea Libro numero: " + ++num);
			log.info("Inserisci codice: ");
			String isbn = sc.next();
			sc.nextLine(); 
			log.info("Inserisci Titolo: ");
			String titolo = sc.nextLine();

			log.info("Anno pubblicazione: ");
			int anno = sc.nextInt();
			if(anno>currentYear ) {
				throw new DateTimeException("ANNO INVALIDO");
			}
			else if(anno<1000) {
				throw new HandleError("L'ANNO NON PUO' ESSERE MINORE DI 1000");
			}
			sc.nextLine(); 
			log.info("Inserisci Pagine: ");
			int pag = sc.nextInt();
			if(pag<0) {
				throw new IllegalArgumentException("NUMERO INVALIDO");
			}
			sc.nextLine(); 
			log.info("Inserisci Autore: ");
			String aut = sc.next();
			sc.nextLine(); 
			log.info("Inserisci Genere: ");
			String gen = sc.next();
			

			Libri book = new Libri(isbn, titolo, anno, pag,aut,gen);
			book.setLibro(book);
			contenuto.add(book);
			
		}
		for (Catalogo catalogo : contenuto) {
			log.info("Elementi: " + catalogo);
		}
		
		}catch (DateTimeException e) {
			log.error("L'ANNO DEVE ESSERE MINORE O UGUALE ALL'ANNO CORRENTE");
		} catch (HandleError e) {
			log.error(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			log.error("SOLO NUMERI POSITIVI");
		}catch (InputMismatchException e) {
			log.error("SOLO NUMERI SONO CONSENTITI");
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
	
	public static void searchByAuthor(Set<Catalogo> contenuto) {
	    log.info("Inserisci Autore: ");
	    String info = sc.next();
	    List<Catalogo> aut = contenuto.stream()
	            .filter(el -> el instanceof Libri && el.getLibro() != null && ((Libri) el).getAutore().equalsIgnoreCase(info))
	            .collect(Collectors.toList());
	    
	    for (Catalogo catalogo : aut) {
	        if (catalogo instanceof Libri) {
	            Libri libro = (Libri) catalogo;
	            log.info("Elementi: " + libro.getAutore());
	        } else if (catalogo instanceof Riviste) {
	            Riviste rivista = (Riviste) catalogo;
	            log.info("Elementi: Riviste [period=" + rivista.getPeriod() + ", ISBN=" + rivista.getISBN() + ", titolo=" + rivista.getTitolo() + ", anno_pubblicazione=" + rivista.getAnno_pubblicazione() + ", pagine=" + rivista.getPagine() + "]");
	        }
	    }
	    
	    aut.forEach(show -> log.info("Catalogo: {}", show));
	}

	public static void salvaDati(Set<Catalogo> contenuto) {
	    String testo = "";
	    for (Catalogo items : contenuto) {
	        testo += "Oggetto: " + 
	                "Anno pubblicazione: " + items.getAnno_pubblicazione() + ", " +
	                "ISBN: " + items.getISBN() + " @ " +
	                "Pagine: " + items.getPagine() + " * " +
	                "Titolo: " + items.getTitolo() + " # ";
	        if (items instanceof Libri) {
	            Libri libro = (Libri) items;
	            testo += "Autore: " + (libro.getLibro() != null ? libro.getLibro().getAutore() : "N/A") + " / " +
	                    "Genere: " + (libro.getLibro() != null ? libro.getLibro().getGenere() : "N/A");
	        }
	        testo += "\n";
	    }

	    try {
	        FileUtils.writeStringToFile(file, testo, "UTF-8", true);
	        log.info("Testo scritto su file " + file.getPath());
	    } catch (IOException e) {
	        log.error("Errore durante la scrittura del file: " + e.getMessage());
	    }
	}

	
	
	public static Set<Catalogo> caricaFile() {
	    Set<Catalogo> contenuto = new HashSet<>();
	    try {
	        String textFile = FileUtils.readFileToString(file, "UTF-8");
	        log.info("oggetti " + textFile);
	        
	        String[] elementi = textFile.split("_");

	        for (String s : elementi) {
	            String[] par = s.split("#");

	            if (par.length >= 2) {
	                String[] values = par[1].split("/");
	                if (values.length >= 4) {
	                    String isbn = values[0].trim();
	                    String titolo = values[1].trim();
	                    int anno_pubblicazione = Integer.parseInt(values[2].trim());
	                    int pagine = Integer.parseInt(values[3].trim());

	                    if (par[0].startsWith("Riviste")) {
	                        Period period = Period.valueOf(values[4].trim());
	                        Riviste rivista = new Riviste(isbn, titolo, anno_pubblicazione, pagine, period);
	                        contenuto.add(rivista);
	                    } else if (par[0].startsWith("Libri")) {
	                        String autore = values[4].trim();
	                        String genere = values[5].trim();
	                        Libri libro = new Libri(isbn, titolo, anno_pubblicazione, pagine, autore, genere);
	                        contenuto.add(libro);
	                    }
	                }
	            }
	        }
	    } catch (IOException e) {
	        log.error("ERRORE DURANTE LA LETTURA DEL FILE: " + e.getMessage());
	    } catch (NumberFormatException e) {
	        log.error("ERRORE DURANTE IL PARSE DEI VALORI NUMERICI: " + e.getMessage());
	    }

	    return contenuto;
	}


}
