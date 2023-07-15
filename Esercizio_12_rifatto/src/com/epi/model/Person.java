package com.epi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.epi.controller.Gender;



@Entity 
@Table(name = "person")
public class Person {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "title", nullable=false)
		private String title;
		
		@Column(name = "surname", nullable=false)
		private String surname;
		
		@Column(nullable = false, unique = true)
		private String email;	
		
		@Column(name = "date_birth", nullable=false)
		private LocalDate birthDate ;
		
		@Column(name = "description", nullable=false)
		private String description;
		
		@Enumerated(EnumType.STRING)
		@Column(name = "gender")
		private Gender sex;
		
		@Column(name = "participants", nullable=false)
		private int numberOfParticipants;

}
