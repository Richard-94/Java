package com.epicode.dispositivi.security.service;

import java.time.LocalDate;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.model.Allocation;
import com.epicode.dispositivi.security.model.Gadget;
import com.epicode.dispositivi.security.model.Worker;
import com.epicode.dispositivi.security.repository.AllocationRepository;
import com.epicode.dispositivi.security.repository.GadgetRepository;

@Service
public class AllocationService {
	
	@Autowired @Qualifier("allocation") private ObjectProvider<Allocation> allocationProvider;
	@Autowired AllocationRepository al;
	@Autowired GadgetRepository g;
	
	public void saveAllocation (Allocation a) {
		al.save(a);
		
	}
	
	
	
		public Allocation createAllocation(Worker workers, Gadget gadgets,LocalDate assignedDate) {
			Status gadgetStatus = gadgets.getStatus();
			 if(gadgetStatus == Status.RETIRED) {
				throw new IllegalArgumentException("Gadget is retired so cannot be assigned");
			}
			else if(gadgetStatus == Status.MAINTENANCE) {
				throw new IllegalArgumentException("Gadget is in  maintenance so it  cannot be assigned");
			}
			else if(gadgetStatus == Status.ALLOCATED) {
				throw new IllegalArgumentException("Gadget has been already allocated so it  cannot be assigned");
			}
			
			else if(gadgetStatus == Status.AVAILABLE) {
				Allocation newAllocation = allocationProvider.getObject().builder()
						.workers(workers)
						.gadgets(gadgets)
						.assignedDate(assignedDate)
						.build();
				
				gadgets.setStatus(Status.ALLOCATED);
				g.save(gadgets);
				
				return newAllocation;
				
				
			}
			 return null;
			
			 
		}
		
		
	
		
			public Allocation createReturnedAllocation(Worker workers, Gadget gadgets,LocalDate returndDate) {
				Status gadgetStatus = gadgets.getStatus();
			
					 if(gadgetStatus == Status.RETIRED) {
							throw new IllegalArgumentException("Gadget is retired so cannot be assigned");
							
						}
						else if(gadgetStatus == Status.MAINTENANCE) {
							throw new IllegalArgumentException("Gadget is in  maintenance so it  cannot be assigned");
						}
						else if (gadgetStatus != Status.ALLOCATED) {
				            throw new IllegalArgumentException("Gadget must be allocated in order to create a return allocation");
				        }
						else  {
							Allocation newAllocation = allocationProvider.getObject().builder()
									.workers(workers)
									.gadgets(gadgets)
									.returnedDate(returndDate)
									.build();
							
							gadgets.setStatus(Status.AVAILABLE);
							g.save(gadgets);
							
							return newAllocation;
							
							
						}
				}
			
			
		

}
