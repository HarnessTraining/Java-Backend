package com.virtusa.project.PgRental.dto;

import com.virtusa.project.PgRental.model.PgType;
import lombok.Data;

import java.util.List;

@Data
public class PropertyDto {
    private long propertyId;
    private String pgName;
    private PgType pgType; // Modify pgType to use the enum type
    private String pgAddress;
    private String pgPhoneNumber;
    private String pgEmail;

    private boolean isApproved;
    private long userId;

    private List<RoomDto> rooms;

    private List<PgFacilitiesDto> pgFacilities;

    private List<AttachmentDto> attachments;

    private List<UserFavoritesDto> userFavorites;

    private String googleMapsLink;

    // getters and setters
    public String getGoogleMapsLink() {
        return googleMapsLink;
    }

    public void setGoogleMapsLink(String googleMapsLink) {
        this.googleMapsLink = googleMapsLink;
    }
    public boolean isIsApproved() {
        return this.isApproved;
    }

    public boolean getIsApproved() {
        return this.isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public List<UserFavoritesDto> getUserFavorites() {
        return this.userFavorites;
    }

    public void setUserFavorites(List<UserFavoritesDto> userFavorites) {
        this.userFavorites = userFavorites;
    }


    public List<PgFacilitiesDto> getPgFacilities() {
        return pgFacilities;
    }

    public void setPgFacilities(List<PgFacilitiesDto> pgFacilitiesDto) {
        this.pgFacilities = pgFacilitiesDto;
    }

    public List<AttachmentDto> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentDto> attachments) {
        this.attachments = attachments;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }

    // Getters and setters for propertyId
    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    // Getters and setters for pgName
    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    // Getters and setters for pgType
    public PgType getPgType() {
        return pgType;
    }

    public void setPgType(PgType pgType) {
        this.pgType = pgType;
    }

    // Getters and setters for pgAddress
    public String getPgAddress() {
        return pgAddress;
    }

    public void setPgAddress(String pgAddress) {
        this.pgAddress = pgAddress;
    }

    // Getters and setters for pgPhoneNumber
    public String getPgPhoneNumber() {
        return pgPhoneNumber;
    }

    public void setPgPhoneNumber(String pgPhoneNumber) {
        this.pgPhoneNumber = pgPhoneNumber;
    }

    // Getters and setters for pgEmail
    public String getPgEmail() {
        return pgEmail;
    }

    public void setPgEmail(String pgEmail) {
        this.pgEmail = pgEmail;
    }

    // Getters and setters for isApproved
    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    // Getters and setters for userId
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
