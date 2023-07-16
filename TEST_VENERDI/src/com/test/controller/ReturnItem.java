package com.test.controller;

import java.time.LocalDate;
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

    public static void lendingItem(List<Lending> elements) {
        log.info("Crea prestito: ");
        log.info("Scegli elemento del catalogo da dare in prestito; 1 per libri oppure 2 per riviste: ");
        int choose = sc.nextInt();
        sc.nextLine();

        LocalDate returnDate = LocalDate.now();
        LocalDate returnP = LocalDate.now().plusDays(30);
        LocalDate actualReturnDate;

        switch (choose) {
            case 1:
            	log.info("Hai scelto un libro.");
                actualReturnDate = returnDate.plusDays(30);
                log.info("Inserisci Codice isbn : ");
                String num = sc.nextLine();  // Use sc.nextLine() instead of sc.next()
                log.info("Inserisci Numero tessera: ");
                Long code = Long.parseLong(sc.nextLine());

                Lending lending = new Lending(Type.LIBRI, num, code, returnDate, returnP, actualReturnDate);
                elements.add(lending);
                break;
            case 2:
                log.info("Hai scelto una rivista.");
              
                actualReturnDate = returnDate.plusDays(30);
                log.info("Inserisci Codice isbn : ");
                String num1 = sc.nextLine();  // Use sc.nextLine() instead of sc.next()
                log.info("Inserisci Numero tessera: ");
                Long code1 = Long.parseLong(sc.nextLine());
                Lending lending1 = new Lending(Type.RIVISTA, num1, code1, returnDate, actualReturnDate, actualReturnDate);
                elements.add(lending1);
                break;
            default:
                log.info("Scelta non valida.");
                return;
        }
    }


}

