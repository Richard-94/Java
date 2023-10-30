package com.tesifacile.project.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tesifacile.project.checking.TesiControl;
import com.tesifacile.project.model.RicieveMessage;
import com.tesifacile.project.repository.TesiRepository;

import jakarta.persistence.EntityNotFoundException;

import com.tesifacile.project.exception.NotNullException;


@Service
public class TesiService {
	@Autowired @Qualifier("message") private ObjectProvider <RicieveMessage> ricieveProvider;
	@Autowired TesiRepository tesiRepo;
	 @Autowired TesiControl tesiControl;

	
	
//	public RicieveMessage createMessage(String name,String message) {
//		RicieveMessage tesiMessage = ricieveProvider.getObject();
//		LocalDate date = LocalDate.now();
//		System.out.println(date);
//		
//		
//		tesiMessage= tesiMessage.builder().name(name)
//				.message(message)
//				.date(date)
//				.build();
//				
//				
//		tesiControl.controlNotNull(tesiMessage);
//		tesiRepo.save(tesiMessage);
//		return tesiMessage;
//		
//	}
	
	public RicieveMessage saveMessage(RicieveMessage tesiMessage) {
			tesiControl.controlNotNull(tesiMessage);
			LocalDate date = LocalDate.now();
			tesiMessage.setDate(date);
			tesiControl.controlNotNull(tesiMessage);
			tesiControl.controlNameExistance(tesiMessage);
			return tesiRepo.save(tesiMessage);
		
	}
	
	 public List<RicieveMessage> getAllMessages() {
	    	List <RicieveMessage> message =  (List<RicieveMessage>) tesiRepo.findAll();
	    	return message;
	    }
	 //@Scheduled(cron = "0 0 0 * * *") // Runs daily at midnight
	 //@Scheduled(cron = "0 * * * * *") // Runs every minute
	 
	 @Scheduled(cron = "0 0 0 * * *") // Runs daily at midnight
	    public void scheduledDeleteMessages() {
		 System.out.println("scheduledDeleteMessages executed");
	        List<RicieveMessage> messagesToDelete = (List<RicieveMessage>) tesiRepo.findAll();
	        System.out.println(messagesToDelete);

	        LocalDate actualDate = LocalDate.now().minusDays(5); // Check if messages are more than 5 days old

	        for (RicieveMessage message : messagesToDelete) {
	            LocalDate creationDate = message.getDate();
	            System.out.println(creationDate);
	            if (creationDate.isAfter(actualDate)) {
	                tesiRepo.delete(message);
	                System.out.println(message + "deleted");
	            }
	        }
	    }

}
