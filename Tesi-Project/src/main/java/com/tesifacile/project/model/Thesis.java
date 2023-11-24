package com.tesifacile.project.model;

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
public class Thesis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false )
	private String name;
	@Column(nullable = false )
	private String surname;
	@Column(nullable = false )
	private String email;
	@Column(nullable = false )
	private String telephone;
	private String titleTheis;
	@Column(columnDefinition = "TEXT")
	private String descriptionThesis;
	private String indexThesis;
	@Column(columnDefinition = "TEXT")
	private String descriptionIndex;
	@Column(nullable = false )
	private Integer pages;
	@Column(nullable = false )
	private String format;
	@Column(nullable = false )
	private Boolean titleThesisPossesion;
	@Column(nullable = false )
	private Boolean indexTheisPossesion;
}
