package com.work.project.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sponsors {
		 @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
		    private String nameSponsor;
		    private String websites;
		    
		    @ManyToOne
		    @JoinColumn(name = "event_id")
		    private Events eventSponsors;


}
