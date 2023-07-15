package com.epi.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.epi.controller.Type;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    private Location locate;

    @Column(name = "date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Participation> participate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type eventType;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Person> numberOfParticipants;

    public Evento() {
        super();
    }

  


	public Evento(String title, Location locate, LocalDate eventDate, String description,
			List<Participation> participate, Type eventType, List<Person> numberOfParticipants) {
		super();
		this.title = title;
		this.locate = locate;
		this.eventDate = eventDate;
		this.description = description;
		this.participate = participate;
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




	public Location getLocate() {
		return locate;
	}




	public void setLocate(Location locate) {
		this.locate = locate;
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




	public List<Participation> getParticipate() {
		return participate;
	}




	public void setParticipate(List<Participation> participate) {
		this.participate = participate;
	}




	public Type getEventType() {
		return eventType;
	}




	public void setEventType(Type eventType) {
		this.eventType = eventType;
	}




	public List<Person> getNumberOfParticipants() {
		return numberOfParticipants;
	}




	public void setNumberOfParticipants(List<Person> numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}




	@Override
	public String toString() {
		return "Evento [id=" + id + ", title=" + title + ", locate=" + locate + ", eventDate=" + eventDate
				+ ", description=" + description + ", participate=" + participate + ", eventType=" + eventType
				+ ", numberOfParticipants=" + numberOfParticipants + "]";
	}


	

	
	

	
	
}
