package com.test.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Lending<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Libri.class)
    @JoinColumn(name = "libri_id")
    private Libri libri;

    @ManyToOne(targetEntity = Riviste.class)
    @JoinColumn(name = "riviste_id")
    private Riviste riviste;



    @Column(name = "lending_date", nullable = false)
    private LocalDate lendingDate;

    @Column(name = "restitution_date", nullable = false)
    private LocalDate restitutionDate;

    @Column(name = "actual_restitution_date", nullable = false)
    private LocalDate actualRestitutionDate;

    @ManyToOne(targetEntity = User.class) 
    @JoinColumn(name = "user_id")
    private User lend;

    public Lending() {
        super();
    }

    public Lending(T item, LocalDate lendingDate, LocalDate restitutionDate, LocalDate actualRestitutionDate) {
        super();
       
        this.lendingDate = lendingDate;
        this.restitutionDate = restitutionDate;
        this.actualRestitutionDate = actualRestitutionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getLend() {
        return lend;
    }

    @Override
    public String toString() {
        return "Lending [id=" + id + ", lendingDate=" + lendingDate + ", restitutionDate="
                + restitutionDate + ", actualRestitutionDate=" + actualRestitutionDate + ", lend=" + lend + "]";
    }
}



