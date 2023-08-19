package com.epicode.dispositivi.security.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.repository.TabletRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Gadget {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    private String brand;
    
    
    private LocalDate statusDate;
    
    private LocalDate availableDate;
    
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer memory;

    @Column(nullable = false)
    private String operatingSystem;

    @Column(nullable = false, unique = true)
    private String isbn;

}
