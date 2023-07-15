package com.test.model;

import java.util.Set;

import javax.persistence.Column;
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
public class Libri extends Catalogo {
	@Column(name = "name_of_author", nullable = false)
    private String autore;
	
	@Column(name = "type_of_book", nullable = false)
    private String genere;
    
    @ManyToOne
    @JoinColumn(name = "catalogo_id")
    private User catalogo_libri;
    
    

	public Libri() {
		super();
	}

	  public Libri(String isbn, String titolo, int anno_pubblicazione, int pagine, String autore, String genere) {
	        super(isbn, titolo, anno_pubblicazione, pagine);
	        this.autore = autore;
	        this.genere = genere;
	    }


	public Libri(String autore, String genere) {
		super();
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



	public User getCatalogo_libri() {
		return catalogo_libri;
	}



	public void setCatalogo_libri(User catalogo_libri) {
		this.catalogo_libri = catalogo_libri;
	}
	
	  public int getLoanDuration() {
	       
	        return 30; 
	    }



	@Override
	public String toString() {
		return "Libri [autore=" + autore + ", genere=" + genere + ", catalogo_libri=" + catalogo_libri
				+ ", getAutore()=" + getAutore() + ", getGenere()=" + getGenere() + ", getCatalogo_libri()="
				+ getCatalogo_libri() + "]";
	}
    
    

}
