package com.epi.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	private Evento event;
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	private Person person;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "confirmation")
	private Confirmed status;

	public Participation() {
		super();
	}

	public Participation(Person person, Confirmed status) {
		super();
		//this.event = event;
		this.person = person;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Evento getEvent() {
		return event;
	}

	public void setEvent(Evento event) {
		this.event = event;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Confirmed getStatus() {
		return status;
	}

	public void setStatus(Confirmed status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Participation [id=" + id + ", event=" + event + ", person=" + person + ", status=" + status
				+ ", getId()=" + getId() + ", getEvent()=" + getEvent() + ", getPerson()=" + getPerson()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}
