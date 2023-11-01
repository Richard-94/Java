package com.tesifacile.project.model;



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
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class RicieveMessage {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @Column(nullable = false)
	 private String name;
	 
	  @Column(nullable = false,columnDefinition = "TEXT")
	  private String message;
	  
	  private LocalDate date;
	  
	  private int myRatingControl;


}
