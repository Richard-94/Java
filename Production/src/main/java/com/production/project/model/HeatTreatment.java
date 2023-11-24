package com.production.project.model;

import com.production.project.costants.TypeOfProcessSpring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class HeatTreatment extends ProcessingStages {
	@Column(nullable = false)
	 @Enumerated(EnumType.STRING)
	 private TypeOfProcessSpring typeOfProcessSpring;
	

}
