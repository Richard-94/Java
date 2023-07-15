package com.test.controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.test.model.Books;
import com.test.model.User;

import org.slf4j.LoggerFactory;




public class Client {
	 static Scanner sc = new Scanner(System.in);
	    static org.slf4j.Logger log = LoggerFactory.getLogger(Books.class);
	    static LocalDate birthDate = LocalDate.now();
	    
	    
	    public static void createUser(Set<User>content) {
	    	int numero;
			log.info("QUANTI UTENTI VUOI INSERIRE: ");
			int num = 0;

			try {
			 numero = sc.nextInt();
			 if(numero<0) {
				 throw new IllegalArgumentException("NUMERO INVALIDO");
			 }
			for(int i = 0; i<numero;i++) {
				log.info("Crea utente numero: " + ++num);
				log.info("nome: ");
				String name = sc.next();
				sc.nextLine(); 
				log.info("Inserisci Cognome: ");
				String surname = sc.nextLine();

				  log.info("Inserisci data di nascita in formato YYYY/M/DD: ");
		            String dateOfBirthInput = sc.nextLine();
		            LocalDate birthDate = LocalDate.parse(dateOfBirthInput, DateTimeFormatter.ofPattern("yyyy/M/d"));

		            if (birthDate.isAfter(LocalDate.now())) {
		                throw new DateTimeException("ANNO INVALIDO");
		            } else if (birthDate.getYear() < 1000) {
		                throw new HandleError("L'ANNO NON PUO' ESSERE MINORE DI 1000");
		            }
				
				log.info("numero tessera viene generata automaticamente ");
				Random random = new Random();
				Long id_card = random.nextLong();
				

				User person = new User(name, surname,birthDate,id_card);
				content.add(person);
				
			}
			
			for (User pers : content) {
				log.info("Numero di utenti: " + pers);
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
