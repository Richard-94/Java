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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.epi.controller.Type;

@Entity 
@Table(name = "eventi")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable=false)
	private String title;
	
	@Column(name = "date", nullable=false)
	private LocalDate eventDate ;
	
	@Column(name = "description", nullable=false)
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Participation participate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Type eventType;
	
	@Column(name = "participants", nullable=false)
	private int numberOfParticipants;

	public Evento() {
		super();
	}

	public Evento(String title, LocalDate eventDate, String description, Type eventType, int numberOfParticipants) {
		super();
		this.title = title;
		this.eventDate = eventDate;
		this.description = description;
		this.eventType = eventType;
		this.numberOfParticipants = numberOfParticipants;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getEventType() {
		return eventType;
	}

	public void setEventType(Type eventType) {
		this.eventType = eventType;
	}

	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", title=" + title + ", eventDate=" + eventDate + ", description=" + description
				+ ", eventType=" + eventType + ", numberOfParticipants=" + numberOfParticipants + "]";
	}
	
	
}
