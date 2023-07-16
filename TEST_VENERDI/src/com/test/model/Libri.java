package com.test.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("book")
public class Libri extends Catalogo {
	@Column(name = "name_of_author", nullable = false)
    private String autore;
	
	@Column(name = "type_of_book", nullable = false)
    private String genere;
    
    
    

	public Libri() {
		super();
	}

	  public Libri(String isbn, String titolo, int anno_pubblicazione, int pagine, String autore, String genere) {
	        super(isbn, titolo, anno_pubblicazione, pagine);
	        this.autore = autore;
	        this.genere = genere;
	        
	    }

	
	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	

	@Override
	public String toString() {
	    return "Libri [autore=" + autore + ", genere=" + genere + ", isbn=" + getIsbn() + ", titolo=" + getTitolo()
	            + ", anno_pubblicazione=" + getAnno_pubblicazione() + ", pagine=" + getPagine() + "]";
	}

	





    

}
