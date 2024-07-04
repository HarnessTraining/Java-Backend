package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintUpdates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long updateId;
    private String updateDescription;
    @CreationTimestamp
    private Timestamp updateTime;

    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaints complaint;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private User updatedBy;

}
