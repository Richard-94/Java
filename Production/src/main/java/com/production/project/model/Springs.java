package com.production.project.model;

import com.production.project.costants.TypeOfProcessSpring;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

public class Springs extends Orders {
	 @Column(nullable = false)
	 @Enumerated(EnumType.STRING)
	private TypeOfProcessSpring typeOfProcessSpring;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Processing processing;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private PreliminariActivities preliminariActivities;
}
