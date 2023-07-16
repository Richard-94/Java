package com.test.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	  

	  @Column(name = "id_tessera", nullable=false)
	  private Long idCard;
	
	
	

	public User() {
		super();
	}


	public User(String name, String surname, LocalDate birthDate, Long idCard) {
	    super();
	    this.name = name;
	    this.surname = surname;
	    this.birthDate = birthDate;
	    this.idCard = idCard;
	    
	    
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


	public Long getIdCard() {
		return idCard;
	}


	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", birthDate=" + birthDate + ", idCard="
				+ idCard + ", getId()=" + getId() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getBirthDate()=" + getBirthDate() + ", getIdCard()=" + getIdCard() + "]";
	}









 

}
