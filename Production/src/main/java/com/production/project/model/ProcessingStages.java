package com.production.project.model;

import java.time.LocalDate;

import com.production.project.costants.OrderType;
import com.production.project.costants.TypeOfProcessSpring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ProcessingStages {
	 @Id
	 @GeneratedValue(strategy = GenerationType.TABLE)
	 private Long id;
	
	 
	 @Column(nullable = false)
	private Long toProduce;
	 @Column(nullable = false)
	private Long produced;
	private Boolean status = false;
	 @Column(nullable = false)
	private String machine;

}
