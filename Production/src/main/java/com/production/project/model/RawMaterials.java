package com.production.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RawMaterials {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(nullable = false,columnDefinition = "TEXT")
	private String steelType;
	 @Column(nullable = false,columnDefinition = "TEXT")
	private Long steelKilos;
	 @Column(nullable = false,columnDefinition = "TEXT")
	private Integer steelDiameter;
	 @Column(nullable = false)
	  private Boolean setUpOk = false;
	    
}
