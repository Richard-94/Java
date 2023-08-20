package com.epicode.dispositivi.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.dispositivi.security.model.Allocation;
import com.epicode.dispositivi.security.model.Worker;
import com.epicode.dispositivi.security.payload.AllocationDtoCreate;
import com.epicode.dispositivi.security.payload.AllocationDtoReturn;
import com.epicode.dispositivi.security.service.AllocationService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/allocations")
public class AllocationController {
	@Autowired AllocationService al;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Allocation>> getWorkers(){
		List<Allocation> allocations = al.getAllAllocations();
		ResponseEntity<List<Allocation>>u = new ResponseEntity <List<Allocation>>(allocations, HttpStatus.OK);
		return u;

	}
	@GetMapping("/{id}")
	 @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getSingleAllocation(@PathVariable Long id){
		Allocation pr = al.allocationFind(id);
		return new ResponseEntity<Allocation>(pr, HttpStatus.OK);

	}
	
	 @PostMapping("/create")
	 @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Object> createAllocation(@RequestBody AllocationDtoCreate allocationDto) {
	        try {
	            Allocation createdAllocation = al.createAllocation(allocationDto);
	            return ResponseEntity.ok(createdAllocation);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	 
	 @PostMapping("/create/return")
	 @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Object> returnAllocation(@RequestBody AllocationDtoReturn allocationDto) {
	        try {
	            Allocation createdAllocation = al.createReturnedAllocation(allocationDto);
	            return ResponseEntity.ok(createdAllocation);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	 
	 @PutMapping("/update/{id}")
	 public ResponseEntity<Object> updateAllocation(@PathVariable Long id, @RequestBody AllocationDtoCreate allocationDto) {
	     try {
	         Allocation updatedAllocation = al.updateAllocation(id, allocationDto);
	         return ResponseEntity.ok(updatedAllocation);
	     } catch (EntityNotFoundException e) {
	         return ResponseEntity.notFound().build();
	     }
	 }


}


















 
//POST AN ALLOCATION FORMAT
//http://localhost:8080/api/allocations/create
//	{
//	  "workerUsername": "alex_j",
//	  "gadgetIsbn": "Vd235",
//	  "assignedDate": "2023-10-25"
//	}

//POST A RETURN ALLOCATION FORMAT
//http://localhost:8080/api/allocations/create/return
//{
//	  "workerUsername": "mclom",
//	  "gadgetIsbn": "ISBN345",
//	  "assignedDate": "2023-08-15",
//	  "returnedDate": "2023-08-25"
//	}


//UPDATE AN ALLOCATION
//http://localhost:8080/api/allocations/update/1
//{
//    "id": 1,
//    "assignedDate": "2023-08-30",
//    "returnedDate": null,
//    "workerUsername": "mclom",
//    "gadgetIsbn": "ISBN789"
//}




