package com.production.project.model;

import com.production.project.costants.TypeOfProcessSpring;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Processing {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	 private Wrapping wrapping;
	 @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	 private HeatTreatment heatTreament;
	 @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	 private Grinding grinding;
	 @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	 private Spraying spraying;
	
}
