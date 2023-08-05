package com.epicode.dispositivi.security.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.epicode.dispositivi.security.constants.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "allocations")
public class Allocation {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private Status status;
	    private Boolean available = true;
	    @Column(nullable = false)
	    private LocalDateTime story;
	    @ManyToOne
	    private Worker workers;
	    @ManyToOne
	    private Gadget gadgets;
	
	

}
