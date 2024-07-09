package com.virtusa.project.PgRental.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.virtusa.project.PgRental.model.SharingType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RoomDto {
    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public SharingType getSharingType() {
        return sharingType;
    }

    public void setSharingType(SharingType sharingType) {
        this.sharingType = sharingType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public PropertyDto getProperty() {
        return property;
    }

    public void setProperty(PropertyDto property) {
        this.property = property;
    }

    private long roomId;
    private long roomNumber;
    private SharingType sharingType;
    private BigDecimal price;
    private Date startDate;
    private Date endDate;

    private int beds;

    @JsonIgnore
    private PropertyDto property;
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

