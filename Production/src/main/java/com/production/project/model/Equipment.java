package com.production.project.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Equipment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;  
	  @Column(nullable = false,columnDefinition = "TEXT")
	    private String machine;
	  @Column(nullable = false,columnDefinition = "TEXT")
	    private String cuttingEquipment;
	  @Column(nullable = false,columnDefinition = "TEXT")
	    private String measurementEquipment;
	  @Column(nullable = false)
	  private Boolean setUpOk = false;
	    
}
