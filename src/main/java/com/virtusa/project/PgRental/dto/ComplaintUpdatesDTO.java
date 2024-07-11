package com.virtusa.project.PgRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintUpdatesDTO {
    private long updateId;
    private String updateDescription;
    private Timestamp updateTimestamp;
    private long complaintId;
    private long updatedBy;

    public long getUpdateId() {
        return this.updateId;
    }

    public void setUpdateId(long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateDescription() {
        return this.updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public Timestamp getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public long getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(long complaintId) {
        this.complaintId = complaintId;
    }

    

    public long getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        this.updatedBy = updatedBy;
    }

}