package com.test.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.LoggerFactory;

import com.test.controller.HandleError;



public class Books {
	 static Scanner sc = new Scanner(System.in);
	    static org.slf4j.Logger log = LoggerFactory.getLogger(Books.class);
	    static int currentYear = LocalDate.now().getYear();
	
	public void creatLibri(Set<Catalogo> contenuto) {
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
			

			Libri book = new Libri(isbn,titolo, anno,pag, aut, gen);
			
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
	

}
