package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean isAdmin;
    private boolean adminVerified;
    private boolean hasProperty;
    private String referralCode;
    private int referralDiscount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Property> propertyList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<UserFavorites> userFavorites;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Complaints> complaints;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Notifications> notifications;

}
