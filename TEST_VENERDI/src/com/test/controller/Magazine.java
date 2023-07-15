package com.test.controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.Entity;

import org.slf4j.LoggerFactory;

import com.test.model.Catalogo;
import com.test.model.Period;
import com.test.model.Riviste;

public class Magazine {
    static Scanner sc = new Scanner(System.in);
    static org.slf4j.Logger log = LoggerFactory.getLogger( Magazine.class);
    static int currentYear = LocalDate.now().getYear();

    public void creatRivisti(Set<Catalogo> contenuto) {
        int numero;
        log.info("QUANTI RIVISTE VUOI INSERIRE?: ");
        int num = 0;

        try {
            numero = sc.nextInt();
            if (numero < 0) {
                throw new IllegalArgumentException("NUMERO INVALIDO");
            }

            for (int i = 0; i < numero; i++) {
                log.info("Crea Rivista numero: " + ++num);
                log.info("Inserisci codice: ");
                String isbn = sc.next();
                sc.nextLine();
                log.info("Inserisci Titolo: ");
                String titolo = sc.nextLine();

                log.info("Anno pubblicazione: ");
                int anno = sc.nextInt();
                if (anno > currentYear) {
                    throw new DateTimeException("ANNO INVALIDO");
                } else if (anno < 1000) {
                    throw new HandleError("L'ANNO NON PUO' ESSERE MINORE DI 1000");
                }
                sc.nextLine();
                log.info("Inserisci Pagine: ");
                int pag = sc.nextInt();
                if (pag < 0) {
                    throw new IllegalArgumentException("NUMERO INVALIDOS");
                }
                log.info("Scegli 0:MENSILE, 1:SEMESTRALE, 2:SETTIMANALE ");
                for (Period period : Period.values()) {
                    log.info("" + period);
                }

                int scegli = sc.nextInt();
                if (scegli > 2) {
                    log.info("LE OPZIONI VANNO DA  0 - 2");
                }
                Period periodoScelto = null;
                switch (scegli) {
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

                Riviste rivista = new Riviste(isbn, titolo, anno, pag, periodoScelto);
                contenuto.add(rivista);
            }

            for (Catalogo catalogo : contenuto) {
                log.info("Elementi: " + catalogo);
            }

            log.info("Vuoi Creare anche Libri?");
        } catch (DateTimeException e) {
            log.error("L'ANNO DEVE ESSERE MINORE O UGUALE ALL'ANNO CORRENTE");
        } catch (HandleError e) {
            log.error(e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("SOLO NUMERI POSITIVI");
        } catch (InputMismatchException e) {
            log.error("SOLO NUMERI SONO CONSENTITI");
        }
    }
}
