package com.test.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity

public class Lending {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	@Column(name = "isbn_code", nullable = false)
	private String isbn;
	

	@Column(name = "card_number", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardNumber;

	@Column(name = "lending_date", nullable = false)
	private LocalDate lendingDate;

	@Column(name = "restitution_date", nullable = false)
	private LocalDate restitutionDate;

	@Column(name = "actual_restitution_date", nullable = false)
	private LocalDate actualRestitutionDate;
	@Enumerated(EnumType.STRING)
	 @Column(name = "Libri_Rivista")
	private Type type;

    public Lending() {
        super();
    }

    public Lending(Type type,String isbn, Long cardNumber, LocalDate lendingDate, LocalDate restitutionDate, LocalDate actualRestitutionDate) {
        super();
        this.isbn = isbn;
        this.cardNumber = cardNumber;
        this.lendingDate = lendingDate;
        this.restitutionDate = restitutionDate;
        this.actualRestitutionDate = actualRestitutionDate;
        this.type = type;
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

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getLendingDate() {
		return lendingDate;
	}

	public void setLendingDate(LocalDate lendingDate) {
		this.lendingDate = lendingDate;
	}

	public LocalDate getRestitutionDate() {
		return restitutionDate;
	}

	public void setRestitutionDate(LocalDate restitutionDate) {
		this.restitutionDate = restitutionDate;
	}

	public LocalDate getActualRestitutionDate() {
		return actualRestitutionDate;
	}

	public void setActualRestitutionDate(LocalDate actualRestitutionDate) {
		this.actualRestitutionDate = actualRestitutionDate;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Lending [id=" + id + ", isbn=" + isbn + ", cardNumber=" + cardNumber + ", lendingDate=" + lendingDate
				+ ", restitutionDate=" + restitutionDate + ", actualRestitutionDate=" + actualRestitutionDate
				+ ", type=" + type + "]";
	}

	


	
}



