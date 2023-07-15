package com.epi.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.epi.controller.Gender;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable=false)
    private String name;
    
    @Column(name = "surname", nullable=false)
    private String surname;
    
    @Column(nullable = false, unique = true)
    private String email;    
    
    @Column(name = "date_birth", nullable=false)
    private LocalDate birthDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender sex;

    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL)
    //@OederBy(value = evento.)
    private List<Participation> participate;
    
    public Person() {
        super();
    }


	public Person(String name, String surname, String email, LocalDate birthDate, Gender sex,
			List<Participation> participate) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birthDate = birthDate;
		this.sex = sex;
		this.participate = participate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public List<Participation> getParticipate() {
		return participate;
	}

	public void setParticipate(List<Participation> participate) {
		this.participate = participate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", birthDate="
				+ birthDate + ", sex=" + sex + ", participate=" + participate + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getSurname()=" + getSurname() + ", getEmail()=" + getEmail() + ", getBirthDate()="
				+ getBirthDate() + ", getSex()=" + getSex() + ", getParticipate()=" + getParticipate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


   
}
