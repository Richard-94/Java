package com.work.project.security.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import com.work.project.security.entity.User;


import com.work.project.security.constants.Accessibility;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private  String location;
    @Column(nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String participants;
    @Column(nullable = false)
    private String address;
    @OneToMany(mappedBy = "eventImages", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ImageMetadata> imageMetadataList = new ArrayList<>(5);

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String organizer;
    @Column(nullable = false)
    private String info_event;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Accessibility disabilities;
    @OneToMany(mappedBy = "eventSponsors", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sponsors>sponsorsList = new ArrayList<>(5);
    @OneToMany(mappedBy = "eventAttendants", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User>attendants = new ArrayList<>();
}
