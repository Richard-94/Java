package com.epicode.dispositivi.security.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

import com.epicode.dispositivi.security.exception.NotNullException;
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
			throw new EntityExistsException("Worker email already exists!!!");
		}
		if(work.existsByUsername(wo.getUsername())) {
			throw new EntityExistsException("Worker Username already exists!!!");
		}
		controlWorker(wo);
		return work.save(wo);
		
	}
	
	public Worker controlWorker (Worker wk) {
		if (wk.getName() == null) {
			throw new NotNullException("Name field cannot be null.");
		}
		if (wk.getSurname() == null) {
			throw new NotNullException("Surname field cannot be null.");
		}
		if (wk.getEmail() == null) {
			throw new NotNullException("Email field cannot be null.");
		}
		if (wk.getUsername() == null) {
			throw new NotNullException("Username field cannot be null.");
		}
		return wk;
	}
	 
	public Worker workerFind(Long id) {
		if(!work.existsById(id)) {
			throw new EntityNotFoundException("Worker doesn't exists!!!");
		}
		return work.findById(id).get();
	}
	
	public Worker workerFindUserName(String name) {
		if(!work.existsByUsername(name)) {
			throw new EntityNotFoundException("UserName doesn't exists!!!");
		}
		return work.findByUsername(name);
	}
	
	public String workerDel(Long id) {
		if(!work.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		 work.deleteById(id);
		 return "Worker deleted";
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
