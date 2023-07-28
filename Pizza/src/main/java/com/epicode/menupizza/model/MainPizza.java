package com.epicode.menupizza.model;

import java.util.List;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public abstract class MainPizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	private Double calories;
	private Double price;
	@ElementCollection
    @Enumerated(EnumType.STRING)
	private List<Ingredients>ingredients = new ArrayList<Ingredients>();
 
}
