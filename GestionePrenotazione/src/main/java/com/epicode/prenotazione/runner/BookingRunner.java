package com.epicode.prenotazione.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.prenotazione.constants.Type;
import com.epicode.prenotazione.model.Building;
import com.epicode.prenotazione.model.Location;

import com.epicode.prenotazione.model.User;
import com.epicode.prenotazione.service.BuildingService;
import com.epicode.prenotazione.service.LocationService;
import com.epicode.prenotazione.service.UserService;



@Component
public class BookingRunner implements CommandLineRunner {
	Logger log = LoggerFactory.getLogger(BookingRunner.class);
	@Autowired UserService serv;
	@Autowired BuildingService build;
	@Autowired LocationService lo;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Run...");
		 
		//CREATION OF USER
		//User first = serv.createUser("Skank12", "Marck Arthur", "mar.art@example.com");
		//User second = serv.createUser("MarieP", "Marina Konst", "m.konst@test.it");
		//serv.saveUser(second);
		//User u = serv.userFind(1l);
		//log.info(""+ u);
		
		
		
		
		//CREATION OF BUILDING
		//Building first1 = build.creatBuilding("Palazzo Duca", "Via casale 12", "Venezia");
		//Building second1 = build.creatBuilding("Ext Tower", "Viale Europa 125", "Brescia");
		//build.saveBuilding(first1);
		//Building b = build.userFind(1l);
		//log.info(""+ b);
		
		
		
		//CREATION OF LOCATION
		
		//Location first2 = lo.createLocation("AB123","Postazione molto accogliente",Type.CONFERENCE_ROOM,build.userFind(2l));
		//Location first3 = lo.createLocation("CD125","Postazione comodo per una persona",Type.PRIVATE,build.userFind(1l));
		//lo.saveLocation(first3);
		
	}

}
