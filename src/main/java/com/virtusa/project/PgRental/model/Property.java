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

    @OneToMany(mappedBy = "property", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Complaints> complaints;

    @OneToMany(mappedBy = "property",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<PgFacilities> pgFacilities;

    @OneToMany(mappedBy = "property",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Room> rooms;

    @OneToMany(mappedBy = "property", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Attachment> attachments;

    @OneToMany(mappedBy = "property",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "property", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<UserFavorites> userFavorites;

    private String googleMapsLink;

    // getters and setters
    public String getGoogleMapsLink() {
        return googleMapsLink;
    }

    public void setGoogleMapsLink(String googleMapsLink) {
        this.googleMapsLink = googleMapsLink;
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    public PgType getPgType() {
        return pgType;
    }

    public void setPgType(PgType pgType) {
        this.pgType = pgType;
    }

    public String getPgAddress() {
        return pgAddress;
    }


    public void setPgAddress(String pgAddress) {
        this.pgAddress = pgAddress;
    }

    public String getPgPhoneNumber() {
        return pgPhoneNumber;
    }

    public void setPgPhoneNumber(String pgPhoneNumber) {
        this.pgPhoneNumber = pgPhoneNumber;
    }

    public String getPgEmail() {
        return pgEmail;
    }

    public void setPgEmail(String pgEmail) {
        this.pgEmail = pgEmail;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Complaints> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaints> complaints) {
        this.complaints = complaints;
    }

    public List<PgFacilities> getPgFacilities() {
        return pgFacilities;
    }

    public void setPgFacilities(List<PgFacilities> pgFacilities) {
        this.pgFacilities = pgFacilities;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<UserFavorites> getUserFavorites() {
        return userFavorites;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", pgName='" + pgName + '\'' +
                ", pgType=" + pgType +
                ", pgAddress='" + pgAddress + '\'' +
                ", pgPhoneNumber='" + pgPhoneNumber + '\'' +
                ", pgEmail='" + pgEmail + '\'' +
                ", isApproved=" + isApproved +
                ", user=" + user +
                ", complaints=" + complaints +
                ", pgFacilities=" + pgFacilities +
                ", rooms=" + rooms +
                ", attachmentsSize=" + (attachments != null ? attachments.size() : "null") +
                ", ratings=" + ratings +
                ", userFavorites=" + userFavorites +
                '}';
    }

    public void setUserFavorites(List<UserFavorites> userFavorites) {
        this.userFavorites = userFavorites;
    }




}
