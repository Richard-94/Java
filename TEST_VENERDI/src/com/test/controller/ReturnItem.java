package com.test.controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.LoggerFactory;

import com.test.model.Lending;
import com.test.model.Libri;
import com.test.model.Riviste;
import com.test.model.Type;
import com.test.model.Catalogo;

public class ReturnItem {
    static Scanner sc = new Scanner(System.in);
    static org.slf4j.Logger log = LoggerFactory.getLogger(ReturnItem.class);

    static int choose;

    public static void lendingItem(List<Lending> elements) throws HandleError {
        log.info("Crea prestito: ");
        log.info("Scegli elemento del catalogo da dare in prestito; 1 per libri oppure 2 per riviste: ");
        int choose = sc.nextInt();
        
        sc.nextLine();

        LocalDate returnDate = LocalDate.now();
        LocalDate returnP = LocalDate.now().plusDays(30);
     
        switch (choose) {
        case 1:
            log.info("Hai scelto un libro.");
            //actualReturnDate = returnDate.plusDays(30);
            log.info("Inserisci Codice isbn : ");
            String isbn = sc.nextLine();
            log.info("Inserisci Numero tessera: ");
            Long cardNumber = Long.parseLong(sc.nextLine());
            log.info("Scrivi vero o falso se il libro è tornato: ");
            boolean returned = Boolean.parseBoolean(sc.nextLine());

			  log.info("Inserisci data ritorno libro YYYY/M/DD: ");
	            String dateInput = sc.nextLine();
	            LocalDate actualReturnDate = LocalDate.parse(dateInput , DateTimeFormatter.ofPattern("yyyy/M/d"));

	            if (actualReturnDate.isAfter(LocalDate.now())) {
	                throw new DateTimeException("ANNO INVALIDO");
	            } else if (actualReturnDate.getYear() < 1000) {
	                throw new HandleError("L'ANNO NON PUO' ESSERE MINORE DI 1000");
	            }
            Lending lending = new Lending(isbn, cardNumber, returnDate, returnP, returned, actualReturnDate, Type.LIBRI);
            elements.add(lending);
            break;
        case 2:
            log.info("Hai scelto una rivista.");
            actualReturnDate = returnDate.plusDays(30);
            log.info("Inserisci Codice isbn : ");
            String isbn1 = sc.nextLine();
            log.info("Inserisci Numero tessera: ");
            Long cardNumber1 = Long.parseLong(sc.nextLine());
            log.info("Scrivi vero o falso se la rivista è tornata: ");
            boolean returned1 = Boolean.parseBoolean(sc.nextLine());
            
            log.info("Inserisci data ritorno libro YYYY/M/DD: ");
            String dateInput1 = sc.nextLine();
            LocalDate actualReturnDate1 = LocalDate.parse(dateInput1 , DateTimeFormatter.ofPattern("yyyy/M/d"));

            if (actualReturnDate.isAfter(LocalDate.now())) {
                throw new DateTimeException("ANNO INVALIDO");
            } else if (actualReturnDate.getYear() < 1000) {
                throw new HandleError("L'ANNO NON PUO' ESSERE MINORE DI 1000");
            }
            
            Lending lending1 = new Lending(isbn1, cardNumber1, returnDate, returnP, returned1, actualReturnDate1, Type.RIVISTA);
            elements.add(lending1);
            break;
           
            default:
                log.info("Scelta non valida.");
                return;
        }
    }


}

