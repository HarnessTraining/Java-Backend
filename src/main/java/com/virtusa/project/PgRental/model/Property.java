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
    private String pgType;

    private String pgAddress;

    private String pgPhoneNumber;

    private String pgEmail;

    private int numberOfRooms;

    private boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @OneToMany(mappedBy = "property", cascade = CascadeType.REMOVE)
    private List<Complaints> complaints;

    @OneToMany(mappedBy = "property",cascade = CascadeType.REMOVE)
    private List<PgFacilities> pgFacilities;

    @OneToMany(mappedBy = "property",cascade = CascadeType.REMOVE)
    private List<Room> rooms;

    @OneToMany(mappedBy = "property", cascade = CascadeType.REMOVE)
    private List<PropertyPhotos> propertyPhotos;

    @OneToMany(mappedBy = "property",cascade = CascadeType.REMOVE)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "property", cascade = CascadeType.REMOVE)
    private List<UserFavorites> userFavorites;
}
