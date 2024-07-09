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

    @OneToMany(mappedBy = "complaint", cascade = CascadeType.REMOVE)
    private List<ComplaintUpdates> complaintUpdates;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private ComplaintStatuses status;

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

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Property getProperty() {
        return this.property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public ComplaintStatuses getStatus() {
        return this.status;
    }

    public void setStatus(ComplaintStatuses status) {
        this.status = status;
    }

    public List<ComplaintUpdates> getComplaintUpdates() {
        return this.complaintUpdates;
    }

    public void setComplaintUpdates(List<ComplaintUpdates> complaintUpdates) {
        this.complaintUpdates = complaintUpdates;
    }

}