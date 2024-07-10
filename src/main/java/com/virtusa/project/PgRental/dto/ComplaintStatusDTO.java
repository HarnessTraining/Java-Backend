package com.virtusa.project.PgRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintStatusDTO {
    private long statusId;
    private String statusName;

    // public long getStatusId() {
    //     return this.statusId;
    // }

    // public void setStatusId(long statusId) {
    //     this.statusId = statusId;
    // }

    public String getStatusName() {
        return this.statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
