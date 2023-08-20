package com.epicode.dispositivi.security.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.epicode.dispositivi.security.model.Allocation;
import com.epicode.dispositivi.security.model.Worker;
import com.epicode.dispositivi.security.service.AllocationService;
import com.epicode.dispositivi.security.service.LaptopService;
import com.epicode.dispositivi.security.service.SmartphoneService;
import com.epicode.dispositivi.security.service.TabletService;
import com.epicode.dispositivi.security.service.WorkerService;

@Configuration
public class AllocationRunner implements CommandLineRunner {
	@Autowired AllocationService al;
	@Autowired LaptopService lp;
	@Autowired SmartphoneService sm;
	@Autowired TabletService tb;
	@Autowired WorkerService wk;

	@Override
	public void run(String... args) throws Exception {
		try {
			//Allocation a = al.createAllocation(wk.workerFindUserName("mclom"),lp.laptopFindIsbn("ISBN789"), LocalDate.of(2022, 10, 25));
			//Allocation a2 = al.createAllocation(wk.workerFindUserName("alex_j"),lp.laptopFindIsbn("ISBN456"), LocalDate.of(2022, 10, 25));
			//Allocation a3 = al.createAllocation(wk.workerFindUserName("alex_j"),sm.smartphoneFindIsbn("Vd235"), LocalDate.of(2023, 10, 25));
			//Allocation a4 = al.createAllocation(wk.workerFindUserName("alex_j"),tb.tabletFindIsbn("ISBN345"), LocalDate.of(2023, 10, 25));
			//al.saveAllocation(a3);
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
	       
	
	}
		
		try {
//		    Worker worker = wk.workerFindUserName("mclom");
//		    Allocation existingAllocation = al.findByWorker(worker);
//		        LocalDate assignedDate = existingAllocation.getAssignedDate();
//		        Allocation a = al.createReturnedAllocation(worker, sm.smartphoneFindIsbn("Vd235"), LocalDate.of(2023, 10, 25), assignedDate);
//		        al.saveAllocation(a);
		    
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}


	
		
	}

}
