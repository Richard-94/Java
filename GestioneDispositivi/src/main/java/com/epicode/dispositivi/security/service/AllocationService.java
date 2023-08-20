package com.epicode.dispositivi.security.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.exception.NotNullException;
import com.epicode.dispositivi.security.model.Allocation;
import com.epicode.dispositivi.security.model.Gadget;
import com.epicode.dispositivi.security.model.Worker;

import com.epicode.dispositivi.security.payload.AllocationDtoCreate;
import com.epicode.dispositivi.security.payload.AllocationDtoReturn;
import com.epicode.dispositivi.security.repository.AllocationRepository;
import com.epicode.dispositivi.security.repository.GadgetRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AllocationService {
	
	@Autowired @Qualifier("allocation") private ObjectProvider<Allocation> allocationProvider;
	@Autowired AllocationRepository al;
	@Autowired GadgetRepository g;
	@Autowired WorkerService w;
	@Autowired GadgetService ga;
	 
	
	public void saveAllocation (Allocation a) {
		al.save(a);
		
	}
	
	public AllocationDtoCreate  controlAllocation (AllocationDtoCreate  al) {
		if (al.getAssignedDate() == null) {
			throw new NotNullException("AssignedDate field cannot be null.");
		}
		if (al.getGadgetIsbn() == null) {
			throw new NotNullException("GadgetIsbn field cannot be null.");
		}
		if (al.getWorkerUsername() == null) {
			throw new NotNullException("WorkerUsername field cannot be null.");
		}
		
		return al;
	}
	
	public AllocationDtoReturn  controlAllocationReturn (AllocationDtoReturn  alt) {
		if (alt.getAssignedDate() == null) {
			throw new NotNullException("AssignedDate field cannot be null.");
		}
		if (alt.getGadgetIsbn() == null) {
			throw new NotNullException("GadgetIsbn field cannot be null.");
		}
		if (alt.getWorkerUsername() == null) {
			throw new NotNullException("WorkerUsername field cannot be null.");
		}
		if (alt.getReturnedDate() == null) {
			throw new NotNullException("ReturnedDate field cannot be null.");
		}
		
		return alt;
	}
	
	
	
	public Allocation createAllocation(AllocationDtoCreate allocationDto) {
	    Worker worker = w.workerFindUserName(allocationDto.getWorkerUsername());
	    Gadget gadget = ga.gadgetFindByIsbn(allocationDto.getGadgetIsbn());
	    
	    Status gadgetStatus = gadget.getStatus();
	    if (gadgetStatus == Status.RETIRED) {
	        throw new IllegalArgumentException("Gadget is retired so cannot be assigned");
	    } else if (gadgetStatus == Status.MAINTENANCE) {
	        throw new IllegalArgumentException("Gadget is in maintenance so it cannot be assigned");
	    } else if (gadgetStatus == Status.ALLOCATED) {
	        throw new IllegalArgumentException("Gadget has already been allocated");
	    } else if (gadgetStatus == Status.AVAILABLE) {
	        Allocation newAllocation = Allocation.builder()
	                .workers(worker)
	                .gadgets(gadget)
	                .assignedDate(allocationDto.getAssignedDate())
	                .build();

	        gadget.setStatus(Status.ALLOCATED);
	        controlAllocation(allocationDto);
	        g.save(gadget);

	        return al.save(newAllocation);
	    }

	    return null;
	}

	
		public Allocation findAssignedDate(Allocation a) {
	        LocalDate assignedDate = a.getAssignedDate();
	        return al.findByAssignedDate(assignedDate);
	    }
		
		public Allocation createReturnedAllocation(AllocationDtoReturn allocationDto) {
		    Worker worker = w.workerFindUserName(allocationDto.getWorkerUsername());
		    Gadget gadget = ga.gadgetFindByIsbn(allocationDto.getGadgetIsbn());
		    Status gadgetStatus = gadget.getStatus();

		    if (gadgetStatus == Status.RETIRED) {
		        throw new IllegalArgumentException("Gadget is retired so cannot be assigned");
		    } else if (gadgetStatus == Status.MAINTENANCE) {
		        throw new IllegalArgumentException("Gadget is in maintenance so it cannot be assigned");
		    } else if (gadgetStatus != Status.ALLOCATED) {
		        throw new IllegalArgumentException("Gadget must be allocated in order to create a return allocation");
		    } else {
		        Allocation newAllocation = Allocation.builder()
		            .workers(worker)
		            .gadgets(gadget)
		            .assignedDate(allocationDto.getAssignedDate())
		            .returnedDate(allocationDto.getReturnedDate())
		            .build();

		        gadget.setStatus(Status.AVAILABLE);
		        g.save(gadget);
		        controlAllocationReturn(allocationDto);

		        return newAllocation;
		    }
		}

			public List<Allocation> getAllAllocations(){
				List<Allocation> u = (List<Allocation>) al.findAll();
				return u;
			}

			public Allocation findByWorker(Worker worker) {
			    return al.findByWorkers(worker);
			}
			
			public Allocation allocationFind(Long id) {
				if(!al.existsById(id)) {
					throw new EntityNotFoundException("Worker doesn't exists!!!");
				}
				return al.findById(id).get();
			}
			
			public Allocation saveAllocationr(Allocation allo) {
				
				return al.save(allo);
				
			}

			
			public Allocation updateAllocation(Long id, AllocationDtoCreate allocationDto) {
			    Optional<Allocation> existingAllocationOptional = al.findById(id);
			    if (existingAllocationOptional.isEmpty()) {
			        throw new EntityNotFoundException("Allocation not found");
			    }
			    Allocation existingAllocation = existingAllocationOptional.get();

			    if (!existingAllocation.getWorkers().getUsername().equals(allocationDto.getWorkerUsername())) {
			        throw new EntityNotFoundException("Id and WorkerUsername do not match");
			    }
			    existingAllocation.setAssignedDate(allocationDto.getAssignedDate());

			    return al.save(existingAllocation);
			}

			
		

}
