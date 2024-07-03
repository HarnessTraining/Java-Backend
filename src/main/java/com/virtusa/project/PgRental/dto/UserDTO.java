package com.virtusa.project.PgRental.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long userId;
    @Column(unique = true, nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    @Column(unique = true, nullable = false)
    private String phoneNumber;
    private boolean adminValid;

    public boolean isAdminValid() {
        return adminValid;
    }

    public void setAdminValid(boolean adminValid) {
        this.adminValid = adminValid;
    }

    private boolean adminVerified;
    private boolean hasProperty;
    private String referralCode;
    private int referralDiscount;

//       private List<PropertyDto> propertyList;
//
//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Rating> ratings;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<UserFavorites> userFavorites;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Complaints> complaints;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Notifications> notifications;

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

//    public boolean isAdmin() {
//        return isAdmin;
//    }
//
//    public void setAdmin(boolean admin) {
//        isAdmin = admin;
//    }

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


}
