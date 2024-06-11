package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId;
    private long roomNumber;
    private String sharingType;

    private BigDecimal price;

    private Date startDate;

    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "propertyId")
    private Property property;
}
