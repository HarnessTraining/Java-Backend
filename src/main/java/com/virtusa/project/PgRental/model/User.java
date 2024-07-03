
package com.virtusa.project.PgRental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean adminValid;

    private boolean adminVerified;
    private boolean hasProperty;
    private String referralCode;
    private int referralDiscount;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<Property> propertyList;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
//    private List<Rating> ratings;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<UserFavorites> userFavorites;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<Complaints> complaints;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Notifications> notifications;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdminValid() {
    return adminValid;
}

    public void setAdminValid(boolean adminValid) {
        this.adminValid = adminValid;
    }
    public boolean isAdminVerified() {
        return adminVerified;
    }

    public void setAdminVerified(boolean adminVerified) {
        this.adminVerified = adminVerified;
    }

    public boolean isHasProperty() {
        return hasProperty;
    }

    public void setHasProperty(boolean hasProperty) {
        this.hasProperty = hasProperty;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public int getReferralDiscount() {
        return referralDiscount;
    }

    public void setReferralDiscount(int referralDiscount) {
        this.referralDiscount = referralDiscount;
    }
//
//    public List<Property> getPropertyList() {
//        return propertyList;
//    }
//
//    public void setPropertyList(List<Property> propertyList) {
//        this.propertyList = propertyList;
////    }
//
//    public List<Rating> getRatings() {
//        return ratings;
//    }
//
//    public void setRatings(List<Rating> ratings) {
//        this.ratings = ratings;
//    }
//
//    public List<UserFavorites> getUserFavorites() {
//        return userFavorites;
//    }
//
//    public void setUserFavorites(List<UserFavorites> userFavorites) {
//        this.userFavorites = userFavorites;
//    }
//
//    public List<Complaints> getComplaints() {
//        return complaints;
//    }
//
//    public void setComplaints(List<Complaints> complaints) {
//        this.complaints = complaints;
//    }

    public List<Notifications> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notifications> notifications) {
        this.notifications = notifications;
    }
}
