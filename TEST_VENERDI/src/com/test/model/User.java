package com.test.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "UserEntity")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "name_user", nullable=false)
	 private String name;
	
	
	 @Column(name = "surname_user", nullable=false)
	 private String surname;
	 
	
	  @Column(name = "date_of_birth", nullable=false)
	  private LocalDate birthDate;
	
	
	@Column(name = "card_number", nullable=false,unique = true)
	private Long id_card;
	
	@OneToMany(mappedBy = "catalogo_libri")
    private Set<Libri> libriSet;
    
    @OneToMany(mappedBy = "catalogo_reviste")
    private Set<Riviste> rivisteSet;
    
    @OneToMany(mappedBy = "lend")
    private Set<Lending<?>> lendingSet;

	public User() {
		super();
	}


	public User(String name, String surname, LocalDate birthDate, Long id_card) {
	    super();
	    this.name = name;
	    this.surname = surname;
	    this.birthDate = birthDate;
	    this.id_card = id_card;
	    
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Long getId_card() {
		return id_card;
	}

	public void setId_card(Long id_card) {
		this.id_card = id_card;
	}

	public Set<Libri> getLibriSet() {
		return libriSet;
	}

	public void setLibriSet(Set<Libri> libriSet) {
		this.libriSet = libriSet;
	}

	public Set<Riviste> getRivisteSet() {
		return rivisteSet;
	}

	public void setRivisteSet(Set<Riviste> rivisteSet) {
		this.rivisteSet = rivisteSet;
	}

	public Set<Lending<?>> getLendingSet() {
		return lendingSet;
	}

	public void setLendingSet(Set<Lending<?>> lendingSet) {
		this.lendingSet = lendingSet;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", birthDate=" + birthDate + ", id_card=" + id_card
				+ "]";
	}

 

}
