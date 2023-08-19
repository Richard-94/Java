package com.epicode.dispositivi.security.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "Workers")

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Worker {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private String surname;

	    @Column(nullable = false, unique = true)
	    private String username;

	    @Column(nullable = false, unique = true)
	    private String email;
	    @JsonIgnore
	    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    private List<Gadget> gadgets = new ArrayList<>();


}
