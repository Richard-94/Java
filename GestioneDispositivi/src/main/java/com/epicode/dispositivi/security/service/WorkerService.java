package com.epicode.dispositivi.security.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

import com.epicode.dispositivi.security.model.Worker;
import com.epicode.dispositivi.security.repository.WorkerRepository;
import java.util.List;

@Service
public class WorkerService {
	@Autowired @Qualifier ("worker") private ObjectProvider<Worker> workerProvider;
	@Autowired WorkerRepository work;
	
	public Worker createWorker(String name,String surname,String username,String email) {
		Worker w = workerProvider.getObject();
		w.setName(name);
		w.setSurname(surname);
		w.setUsername(username);
		w.setEmail(email);
		return w;
	}
	
	
	public Worker saveWorker(Worker wo) {
		if(work.existsByEmail(wo.getEmail())) {
			throw new EntityExistsException("User email exists!!!");
		}
		return work.save(wo);
		
	}
	 
	public Worker workerFind(Long id) {
		if(!work.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		return work.findById(id).get();
	}
	
	public String workerDel(Long id) {
		if(!work.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		 work.deleteById(id);
		 return "contact deleted";
	}
	
	
	public Worker updateWorker(Long id, Worker w) {
		if(!work.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		if(id != w.getId()) {
			throw new EntityNotFoundException("Id and UserID do not match!");
		}
		
		return work.save(w);
	}
	
	
	public List<Worker> getAllWorkers(){
		List<Worker> u = (List<Worker>) work.findAll();
		return u;
	}
	

}
