package com.test.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Riviste")
public class Riviste extends Catalogo {
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




	  public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	@Override
	  public String toString() {
	      return "Riviste [isbn=" + getIsbn() + ", titolo=" + getTitolo() + ", anno_pubblicazione=" + getAnno_pubblicazione()
	              + ", pagine=" + getPagine() + ", period=" + period + "]";
	  }





}
