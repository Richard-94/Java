package com.production.project.runner;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.production.project.costants.OrderType;
import com.production.project.costants.TypeOfProcessSpring;
import com.production.project.exception.NotNullException;
import com.production.project.model.PreliminariActivities;
import com.production.project.model.Processing;
import com.production.project.model.Springs;
import com.production.project.repository.PreliminariActivitiesRepository;
import com.production.project.repository.ProcessingRepository;
import com.production.project.service.PreliminariActivitiesService;
import com.production.project.service.SpringsService;

@Component
public class SpringsRunner implements ApplicationRunner {
	@Autowired SpringsService  springsServ;
	@Autowired PreliminariActivitiesRepository preliminariRepo;
	@Autowired ProcessingRepository processRepo;

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("Run..");
		try {

			
			LocalDate date = LocalDate.of(2022, 5, 25);
			LocalDate date1 = LocalDate.of(2021, 10, 01);
			LocalDate date2 = LocalDate.of(2022, 01, 21);
			LocalDate date3 = LocalDate.of(2022, 02, 17);
			
			
			Optional<PreliminariActivities>activitiesOptional  =preliminariRepo.findById(1652L) ;
			Optional<Processing>processingOptional = processRepo.findById(6L);
			
			
			//String description = "Molla premente in filo Aisi302 mm. 2.80 DE 25.40 LL. 46.00 SPT 7";
			//String description1 = "Molla premente in filo C98 mm. 2.40 DE 26.50 LL. 59.00 spt 8.5 molatura";
			String description2 = "Molla premente in filo C98 mm. 2.40 DE 26.50 LL. 59.00 spt 8.5 molatura";
			String description3 = "Molla premente in filo C85 mm. 2.20 DE 23.70 LL. 55.00 SPT 7.00 molatura";
			    
			 PreliminariActivities preliminari = activitiesOptional.orElseThrow(() -> new NotNullException("Attività preliminari non presenti"));
	            Processing process = processingOptional.orElseThrow(() -> new NotNullException("Lavorazioni previste non presenti"));

			    
			    //PreliminariActivities preliminari = activitiesOptional.orElseThrow(() -> new NotNullException("Attività preliminari non presenti"));
			   // Processing process = processingOptional.orElseThrow(() -> new NotNullException("Lavorazioni previste non presenti"));
			    
			    
			//springsServ.createSprings("1430", OrderType.Molle,date,"P-50","211439",description,"C85",TypeOfProcessSpring.Avvolgimento,process,preliminari);
			
			//springsServ.createSprings("1429", OrderType.Molle,date1,"D-25","211687/1",description1,"Aisi",TypeOfProcessSpring.Avvolgimento,process,preliminari);
	          
	          //springsServ.createSprings("65", OrderType.Molle,date2,"O-36","220086",description2,"Aisi",TypeOfProcessSpring.Avvolgimento,process,preliminari);
	            
	          //springsServ.createSprings("237", OrderType.Molle,date3,"B-43","220274/2",description3,"C85",TypeOfProcessSpring.Avvolgimento,process,preliminari);
			
			//springsServ.createSprings("1429", OrderType.Molle,date1,"D-25","211687/1",description,"Aisi",TypeOfProcessSpring.Avvolgimento,process,preliminari);
			
		}catch (NotNullException e) {
            System.err.println("Error: " + e.getMessage());
           
        }catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
           
        }
		
	}
	

}
