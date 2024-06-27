package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyPhotos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long photoId;
    private String photoFileName;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
}
