package com.epicode.jdbc;

import java.time.LocalDate;
import java.util.Date;

public class Students {
	private Integer id;
	private String name;
	private String surname;
	private String gender;
	private String birthdate;
	private Integer avg;
	private Integer minVote;
	private Integer maxVote;
	
	public Students(Integer id, String name, String surname, String gender, String birthdate, Integer avg,
			Integer minVote, Integer maxVote) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.avg = avg;
		this.minVote = minVote;
		this.maxVote = maxVote;
	}
	public String getName() {
		return name;
	}
	
	
	
	public Students(String name, String surname, String gender, String birthdate, Integer avg, Integer minVote,
			Integer maxVote) {
		super();
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.avg = avg;
		this.minVote = minVote;
		this.maxVote = maxVote;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public Integer getAvg() {
		return avg;
	}
	public void setAvg(Integer avg) {
		this.avg = avg;
	}
	public Integer getMinVote() {
		return minVote;
	}
	public void setMinVote(Integer minVote) {
		this.minVote = minVote;
	}
	public Integer getMaxVote() {
		return maxVote;
	}
	public void setMaxVote(Integer maxVote) {
		this.maxVote = maxVote;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", surname=" + surname + ", gender=" + gender + ", birthdate="
				+ birthdate + ", avg=" + avg + ", minVote=" + minVote + ", maxVote=" + maxVote + "]";
	}

	
	
	

}
