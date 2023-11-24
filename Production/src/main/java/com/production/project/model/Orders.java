package com.production.project.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.production.project.costants.OrderType;

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
public class Orders {
	 @Id
	 @GeneratedValue(strategy = GenerationType.TABLE)
	 private Long id;
	 private String orderNumber;
	 @Column(nullable = false)
	 @Enumerated(EnumType.STRING)
	 private OrderType orderType;
	 @Column(nullable = false)
	 private LocalDate orderDate;
	 @Column(nullable = false)
	 private String client;
	 @Column(nullable = false)
	 private String orderSerialNumber;
	 @Column(nullable = false,columnDefinition = "TEXT")
	 private String orderDescription;
	 @Column(nullable = false)
	 private String steelType;
	
}
