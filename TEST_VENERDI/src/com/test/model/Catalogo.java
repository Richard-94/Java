package com.test.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class Catalogo {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;


    @Column(name = "isbn_code", nullable = false, unique = true)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String titolo;

    @Column(name = "date_of_pubblication", nullable = false)
    private int anno_pubblicazione;

    @Column(name = "number_of_pages", nullable = false)
    private int pagine;

   
    public Catalogo() {
        super();
    }
	public Catalogo(String isbn, String titolo, int anno_pubblicazione, int pagine) {
		super();
		this.isbn = isbn;
		this.titolo = titolo;
		this.anno_pubblicazione = anno_pubblicazione;
		this.pagine = pagine;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public int getAnno_pubblicazione() {
		return anno_pubblicazione;
	}


	public void setAnno_pubblicazione(int anno_pubblicazione) {
		this.anno_pubblicazione = anno_pubblicazione;
	}


	public int getPagine() {
		return pagine;
	}


	public void setPagine(int pagine) {
		this.pagine = pagine;
	}

}
