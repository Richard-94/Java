package com.epicode.dispositivi.security.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Smartphone extends Gadget {
	
	@Column(nullable = false)
	private String operatingSystemVersion;	
	@Column(nullable = false)
	private Integer numOfSims;
	
	
}
