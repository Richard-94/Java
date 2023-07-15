package com.epi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.epi.controller.Confirmed;
import com.epi.controller.Gender;

@Entity
@Table(name = "participants")
public class Participation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "participate") 
	private Evento event;
	
	private Person person;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "confirmation")
	private Confirmed status;

	public Participation() {
		super();
	}
	
	
}
