package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Complaints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long complaintId;
    private String title;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean isClosed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private ComplaintStatuses status;

    @OneToMany(mappedBy = "complaint", cascade = CascadeType.REMOVE)
    private List<ComplaintUpdates> complaintUpdates;
}