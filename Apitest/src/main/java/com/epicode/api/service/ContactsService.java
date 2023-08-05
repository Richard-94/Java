package com.epicode.api.service;

import java.time.ZoneId;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.api.model.Contacts;
import com.epicode.api.repository.ContactsDaoRepository;
import com.github.javafaker.Faker;

@Service
public class ContactsService {
	@Autowired @Qualifier ("contacts") private ObjectProvider<Contacts> contactsProvider;
	@Autowired ContactsDaoRepository contacts;
	
	public Contacts creatContacts() {
		Faker faker = new Faker(new Locale("it-IT"));
		
		Contacts c = contactsProvider.getObject().builder()
				
                .name(faker.name().fullName())
                .userName(faker.name().username())
                .email(faker.internet().emailAddress())
                .surname(faker.name().lastName())
                .birth(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .build();
		
		
		contacts.save(c);
		
		return c;

	}

	
	public Contacts saveContacts(Contacts co) {
		return contacts.save(co);
	}
	
	
	public List<Contacts> fetchAll(){
		List<Contacts> c = (List<Contacts>) contacts.findAll();
		return c;
	}
	
	public Contacts fetchOneUser(Long id) {
		Contacts c = contacts.findById(id).get();
		return c;
	}
}
