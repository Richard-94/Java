package com.epicode.prenotazione.runner;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.prenotazione.constants.Type;
import com.epicode.prenotazione.model.Building;
import com.epicode.prenotazione.model.Location;
import com.epicode.prenotazione.model.Prenotation;
import com.epicode.prenotazione.model.User;
import com.epicode.prenotazione.service.BuildingService;
import com.epicode.prenotazione.service.LocationService;
import com.epicode.prenotazione.service.PrenotationService;
import com.epicode.prenotazione.service.UserService;



@Component
public class BookingRunner implements CommandLineRunner {
	Logger log = LoggerFactory.getLogger(BookingRunner.class);
	@Autowired UserService serv;
	@Autowired BuildingService build;
	@Autowired LocationService lo;
	@Autowired PrenotationService pre;
	
	@Override
	public void run(String... args) throws Exception {
	  try {
		//log.info("Run...");
		 
		//CREATION OF USER
		//User first = serv.createUser("Skank12", "Marck Arthur", "mar.art@example.com");
		//User second = serv.createUser("MarieP", "Marina Konst", "m.konst@test.it");
		//User third = serv.createUser("mental", "Ema Sirn", "sirn_ema.art@example.com");
		//serv.saveUser(third);
		//User u = serv.userFind(1l);
		//log.info(""+ u);
		
		
		
		
		
		//CREATION OF BUILDING
		//Building first1 = build.creatBuilding("Palazzo Duca", "Via casale 12", "Venezia");
		//Building first4 = build.creatBuilding("Palazzo Reale", "Via Canton 1", "Venezia");
		//Building first5 = build.creatBuilding("Palazzo Reale", "Via Canton 1", "Venezia");
		//Building second1 = build.creatBuilding("Ext Tower", "Viale Europa 125", "Brescia");
		//Building third1 = build.creatBuilding("Green Village", "vicolo cechin 1", "Verona");
		//build.saveBuilding(first5);
		//Building b = build.userFind(1l);
		//log.info(""+ b);
		
		
		
		//CREATION OF LOCATION
		
		//Location first2 = lo.createLocation("AB123","Postazione molto accogliente",Type.CONFERENCE_ROOM,build.userFind(1l));
		//Location first3 = lo.createLocation("CD125","Postazione comodo per una persona",Type.PRIVATE,build.userFind(2l));
		//Location first4 = lo.createLocation("XC235","Postazione in mezzo al verde",Type.OPENSPACE,build.userFind(3l));
		//Location first5 = lo.createLocation("Fr256","Postazione con vista mare",Type.PRIVATE,build.userFind(4l));
		//Location first6 = lo.createLocation("Gh256","Postazione con vista mare",Type.CONFERENCE_ROOM,build.userFind(5l));
		//lo.saveLocation(first6);
		
		
	
		
		
				
		
			List<Location> list = lo.printAllLocations();
			list.forEach(l->System.out.println(l));
			
			//CERCARE PER TIPO
			
			log.info("CERCARE PER TIPO DI PALAZZO");
			log.info("*********************************************************************");
			

					List<Location> locations = lo.findByCityAndType(Type.PRIVATE, "Venezia");
			
			Prenotation p = pre.prenote(serv.userFind(2l), lo.locationFind(2l),LocalDate.of(2023, 8, 13));
			pre.savePrenotation(p);
//			
		}catch (Exception e) {
           
            log.error("An error occurred: " + e.getMessage());
        }
//		
//		
//		
	}
	
	

}
