package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Riviste extends Catalogo {
	
	 @ManyToOne
	 @JoinColumn(name = "catalogo_id")
	 private User catalogo_reviste;
	 
	 @Enumerated(EnumType.STRING)
	 @Column(name = "period_of_the_riviste")
	private Period period;

	public Riviste() {
		super();
	}
	
	 public Riviste(String isbn, String titolo, int anno_pubblicazione, int pagine,Period period) {
	        super(isbn, titolo, anno_pubblicazione, pagine);
	        this.period = period;
	    }

	

	public User getCatalogo_reviste() {
		return catalogo_reviste;
	}

	public void setCatalogo_reviste(User catalogo_reviste) {
		this.catalogo_reviste = catalogo_reviste;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
	
	

	  public int getLoanDuration() {
	       
	        return 30; 
	    }


	@Override
	public String toString() {
		return "Riviste [catalogo_reviste=" + catalogo_reviste + ", period=" + period + ", getCatalogo_reviste()="
				+ getCatalogo_reviste() + ", getPeriod()=" + getPeriod() + "]";
	}


}
