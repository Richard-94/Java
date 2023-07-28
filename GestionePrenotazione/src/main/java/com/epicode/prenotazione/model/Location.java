package com.epicode.prenotazione.model;

import com.epicode.prenotazione.constants.Type;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private String code;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;
	@Column(nullable = false)
	private int occupants;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Building building;
	
	public void setOccupants() {
		if(getType().equals(Type.CONFERENCE_ROOM)) {
			occupants = 100;
		}
		else if (getType().equals(Type.OPENSPACE)) {
			occupants = 150;
		}
		
		else if (getType().equals(Type.PRIVATE)) {
			occupants = 1;
		}else {
			System.out.println("Unidentified Type");
		}
	
	}

}
  

