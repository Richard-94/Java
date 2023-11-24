package com.production.project.model;

import com.production.project.costants.TypeOfPaint;

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
public class Paintings {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(nullable = false)
	 private String color;
	 @Column(nullable = false)
	 @Enumerated(EnumType.STRING)
	 private TypeOfPaint typeOfPaint;
	 @Column(nullable = false)
	  private Boolean setUpOk = false;
	    
	   
}
