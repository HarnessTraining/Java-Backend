package com.virtusa.project.PgRental.dto;

import lombok.Data;

@Data
public class RoomAvailabilityUpdateDto {
    private long roomId;
    private int beds;
    private boolean available;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
