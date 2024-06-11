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
public class PgFacilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pgFacilitiesId;
    private BigDecimal cost;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "propertyId")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "facilityId")
    private Facilities facilities;

}
