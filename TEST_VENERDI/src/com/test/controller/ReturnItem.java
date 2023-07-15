package com.test.controller;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.LoggerFactory;

import com.test.model.Lending;
import com.test.model.Libri;
import com.test.model.Riviste;
import com.test.model.Catalogo;

public class ReturnItem {
    static Scanner sc = new Scanner(System.in);
    static org.slf4j.Logger log = LoggerFactory.getLogger(ReturnItem.class);

    static int choose;

    public static void lendingItem(Set<Lending<Catalogo>> elements) {
        log.info("Crea prestito: ");
        log.info("Scegli elemento del catalogo da dare in prestito; 1 per libri oppure 2 per riviste: ");
        int choose = sc.nextInt();

        LocalDate returnDate = LocalDate.now();
        LocalDate returnP = LocalDate.now().plusDays(30);
        LocalDate actualReturnDate;

        switch (choose) {
            case 1:
                log.info("Hai scelto un libro.");
                Libri book = new Libri();
                actualReturnDate = returnDate.plusDays(30);
                Lending<Catalogo> lending = new Lending<Catalogo>(book, returnDate, returnP, actualReturnDate);
                elements.add(lending);
                break;
            case 2:
                log.info("Hai scelto una rivista.");
                Riviste rivista = new Riviste();
                actualReturnDate = returnDate.plusDays(30);
                Lending<Catalogo> lending1 = new Lending<Catalogo>(rivista, returnDate, returnP, actualReturnDate);
                elements.add(lending1);
                break;
            default:
                log.info("Scelta non valida.");
                return;
        }
    }
}

