package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ratingId;
    private int rating;
    private String description;
    private LocalDateTime reviewDate;

    @ManyToOne
    @JoinColumn(name = "propertyId")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @PrePersist
    protected void onCreate() {
        this.reviewDate = LocalDateTime.now();
    }
}
