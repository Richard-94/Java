package com.test.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.model.Books;
import com.test.model.Catalogo;
import com.test.model.Lending;
import com.test.model.Libri;
import com.test.model.Riviste;
import com.test.model.User;
import com.epi.model.JpaUtil;

public class MainProject {
    static EntityManager manageEvent = JpaUtil.getEntityManagerFactory().createEntityManager();
    static Logger log = LoggerFactory.getLogger(MainProject.class);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            //Client client = new Client();
           //Set<User> userList = new HashSet<>();
           //client.createUser(userList);
           //saveUser(userList);

            //Magazine magazine = new Magazine();
            //Set<Catalogo> contenuto = new HashSet<>();
            //magazine.creatRivisti(contenuto);


            //Books book = new Books();
            //Set<Catalogo> contenuto1 = new HashSet<>();
            //book.creatLibri(contenuto1);

            //Set<Catalogo> catalogoSet = new HashSet<>();
            //catalogoSet.addAll(contenuto);
            //catalogoSet.addAll(contenuto1);
           	//saveEvent(catalogoSet);
            
        	 //ReturnItem restitute = new ReturnItem();
        	//List<Lending> lendingList = new ArrayList<>(); 
            //restitute.lendingItem(lendingList);
            //saveLending(lendingList);

            
        	
        	//Catalogo c = readDetails("123456789000");
        	//log.info ("Elemento" + c);
        	
        	//Catalogo d = readDetails1("123456");
        	//log.info ("Elemento" + d);
        	
        	//Catalogo d = readDetails1("123456");
        	//remove(d);
        	
        	//Catalogo b = readPubblicationLibri(1890);
        	//log.info ("Elemento" + b);
        	

        	//Catalogo e = readPubblicationRiviste(2006);
        	//log.info ("Elemento" + e);
        	

        	//Catalogo f =readPubblicationAuthor("Giu");
        	//log.info ("Elemento" + f);
        	

        	//Catalogo g =readTitleLibri("Mantrac");
        	//log.info ("Elemento" + g);
        	
        	//Catalogo h =readTitleRiviste("Mia");
        	//log.info ("Elemento" + h);
        	
          //List<Lending> i =readLendedItems(829382253564601729l);
          //log.info ("Elemento" + i);
          
          findExpiredUnrestitutedLoans();
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            JpaUtil.getEntityManagerFactory();
            sc.close();
        }
    }

    public static void saveEvent(Set<Catalogo> catalogoSet) {
        try {
            manageEvent.getTransaction().begin();
            for (Catalogo catalogo : catalogoSet) {
                manageEvent.persist(catalogo);
            }
            
            manageEvent.getTransaction().commit();
            log.info("Catalogo creato con successo");
        } catch (Exception e) {
            manageEvent.getTransaction().rollback();
            log.error("Errore nella creazione di Catalogo e User: " + e.getMessage());
        }
    }
    
    public static void saveUser( Set<User> userList) {
        try {
            manageEvent.getTransaction().begin();
            for (User user : userList) {
                manageEvent.persist(user);
            }
            manageEvent.getTransaction().commit();
            log.info("User creato con successo");
        } catch (Exception e) {
            manageEvent.getTransaction().rollback();
            log.error("Errore nella creazione di Catalogo e User: " + e.getMessage());
        }
    }
    
    public static void saveLending(List<Lending> elements) {
        try {
            manageEvent.getTransaction().begin();
            for (Lending lending : elements) {
                manageEvent.persist(lending);
            }
            manageEvent.getTransaction().commit();
            log.info("Prestiti creati con successo");
        } catch (Exception e) {
            manageEvent.getTransaction().rollback();
            log.error("Errore nella creazione dei prestiti: " + e.getMessage());
        }
    }

    
    public static Libri readDetails(String isbn) {
        manageEvent.getTransaction().begin();
        TypedQuery<Libri> query = manageEvent.createQuery("SELECT l FROM Libri l WHERE l.isbn = :isbn", Libri.class);
        query.setParameter("isbn", isbn);
        Libri search = query.getSingleResult();
        manageEvent.getTransaction().commit();
        return search;
    }
    
    public static Riviste readDetails1(String isbn) {
        manageEvent.getTransaction().begin();
        TypedQuery<Riviste> query = manageEvent.createQuery("SELECT l FROM Riviste l WHERE l.isbn = :isbn", Riviste.class);
        query.setParameter("isbn", isbn);
        Riviste search = query.getSingleResult();
        manageEvent.getTransaction().commit();
        return search;
    }
    
    public static void remove(Catalogo catalogo) {
        manageEvent.getTransaction().begin();
        manageEvent.remove(catalogo);
        manageEvent.getTransaction().commit();
        log.info("Elemnto rimosso");
       
    }
    
    public static Libri readPubblicationLibri(int anno_pubblicazione) {
        manageEvent.getTransaction().begin();
        TypedQuery<Libri> query = manageEvent.createQuery("SELECT l FROM Libri l WHERE l.anno_pubblicazione = :anno_pubblicazione", Libri.class);
        query.setParameter("anno_pubblicazione",  anno_pubblicazione);
        Libri search = query.getSingleResult();
        manageEvent.getTransaction().commit();
        return search;
    }
    
    public static Riviste readPubblicationRiviste(int anno_pubblicazione) {
        manageEvent.getTransaction().begin();
        TypedQuery<Riviste> query = manageEvent.createQuery("SELECT l FROM Riviste l WHERE l.anno_pubblicazione = :anno_pubblicazione", Riviste.class);
        query.setParameter("anno_pubblicazione",  anno_pubblicazione);
        Riviste search = query.getSingleResult();
        manageEvent.getTransaction().commit();
        return search;
    }
    
    public static Libri readPubblicationAuthor(String autore) {
        manageEvent.getTransaction().begin();
        TypedQuery<Libri> query = manageEvent.createQuery("SELECT l FROM Libri l WHERE l.autore = :autore", Libri.class);
        query.setParameter("autore", autore);
        Libri search = query.getSingleResult();
        manageEvent.getTransaction().commit();
        return search;
    }
    
    public static Libri readTitleLibri(String title) {
        manageEvent.getTransaction().begin();
        TypedQuery<Libri> query = manageEvent.createQuery("SELECT l FROM Libri l WHERE l.titolo = :title", Libri.class);
        query.setParameter("title", title);
        Libri search = query.getSingleResult();
        manageEvent.getTransaction().commit();
        return search;
    }

    public static Riviste readTitleRiviste(String title) {
        manageEvent.getTransaction().begin();
        TypedQuery<Riviste> query = manageEvent.createQuery("SELECT l FROM Riviste l WHERE l.titolo = :title", Riviste.class);
        query.setParameter("title", title);
        Riviste search = query.getSingleResult();
        manageEvent.getTransaction().commit();
        return search;
    }

    public static List<Lending> readLendedItems(Long card) {
        manageEvent.getTransaction().begin();
        TypedQuery<Lending> query = manageEvent.createQuery("SELECT l FROM Lending l WHERE l.cardNumber = :cardNumber", Lending.class);
        query.setParameter("cardNumber", card);
        List<Lending> searchList = query.getResultList();
        manageEvent.getTransaction().commit();
        return searchList;
    }
    
    public static List<Lending> findExpiredUnrestitutedLoans() {
        LocalDate currentDate = LocalDate.now();
        manageEvent.getTransaction().begin();
        TypedQuery<Lending> query = manageEvent.createQuery(
            "SELECT l FROM Lending l WHERE l.returnDate < :currentDate AND l.returned = false",
            Lending.class
        );
        query.setParameter("currentDate", currentDate);
        List<Lending> searchList = query.getResultList();
        manageEvent.getTransaction().commit();
        return searchList;
    }



}