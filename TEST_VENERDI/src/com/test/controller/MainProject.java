package com.test.controller;

import java.util.Set;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import com.test.model.Catalogo;
import com.test.model.User;

import com.epi.model.Evento;
import com.epi.model.JpaUtil;
import com.test.model.Lending;
import com.test.model.Riviste;
import com.test.model.Books;

public class MainProject {

    static EntityManager manageEvent = JpaUtil.getEntityManagerFactory().createEntityManager();
    static Logger log = LoggerFactory.getLogger(MainProject.class);

   public static void main(String[] args) {
      try {
            Magazine magazine = new Magazine();
            Set<Catalogo> contenuto = new HashSet<>();

            magazine.creatRivisti(contenuto);

            Books book = new Books();
            Set<Catalogo> contenuto1 = new HashSet<>();

            book.creatLibri(contenuto1);

            Set<Catalogo> catalogoSet = new HashSet<>();
            catalogoSet.addAll(contenuto);
            catalogoSet.addAll(contenuto1);

            saveEvent(catalogoSet);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            //JpaUtil.getEntityManagerFactory();
        }
    }

    public static void saveEvent(Set<Catalogo> catalogoSet) {
        try {
            manageEvent.getTransaction().begin();
            for (Catalogo catalogo : catalogoSet) {
                manageEvent.persist(catalogo);
            }
            manageEvent.getTransaction().commit();
            log.info("Catalogo saved successfully");
        } catch (Exception e) {
            manageEvent.getTransaction().rollback();
            log.error("Error occurred while saving Catalogo: " + e.getMessage());
        }
    }
}


