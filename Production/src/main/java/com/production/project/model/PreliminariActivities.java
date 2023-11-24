package com.production.project.model;

import java.time.LocalDate;

import com.production.project.costants.OrderType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
public class PreliminariActivities {
	 @Id
	 @GeneratedValue(strategy = GenerationType.TABLE)
	 private Long id;
	 @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private RawMaterials rawMaterials;
	 @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Equipment equipment;
	 @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private ManufacturingApproval manufacturingApproval;
	 @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	 private Paintings painting;
	
	

}
