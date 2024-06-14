package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long propertyId;
    private String pgName;

    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private PgType pgType;
    //private String pgType;

    private String pgAddress;

    private String pgPhoneNumber;

    private String pgEmail;



    private boolean isApproved;

    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Complaints> complaints;

    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    private List<PgFacilities> pgFacilities;

    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    private List<Room> rooms;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<PropertyPhotos> propertyPhotos;

    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<UserFavorites> userFavorites;
}
