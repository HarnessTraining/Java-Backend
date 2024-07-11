package com.virtusa.project.PgRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintsDTO {
    private long complaintId;
    private String title;
    private String description;
    private Timestamp updatedAt;
    private Timestamp createdAt;
    private boolean isClosed;
    private long userId;
    private long propertyId;
    private long statusId;
    private List<ComplaintUpdatesDTO> complaintUpdates;

    // public ComplaintsDTO() {
    //     this.createdAt = Timestamp.from(Instant.now());
    // }

    public long getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(long complaintId) {
        this.complaintId = complaintId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public boolean isIsClosed() {
        return this.isClosed;
    }

    public boolean getIsClosed() {
        return this.isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPropertyId() {
        return this.propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public long getStatusId() {
        return this.statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public List<ComplaintUpdatesDTO> getComplaintUpdates() {
        return this.complaintUpdates;
    }

    public void setComplaintUpdates(List<ComplaintUpdatesDTO> complaintUpdates) {
        this.complaintUpdates = complaintUpdates;
    }
}
