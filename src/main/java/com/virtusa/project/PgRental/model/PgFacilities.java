package com.virtusa.project.PgRental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Property property;

    @ManyToOne
    @JoinColumn(name = "facilityId")
    private Facilities facilities;

    public long getPgFacilitiesId() {
        return pgFacilitiesId;
    }

    public void setPgFacilitiesId(long pgFacilitiesId) {
        this.pgFacilitiesId = pgFacilitiesId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Facilities getFacilities() {
        return facilities;
    }

    public void setFacilities(Facilities facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "{" +
            " pgFacilitiesId='" + getPgFacilitiesId() + "'" +
            ", cost='" + getCost() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", property='" + getProperty() + "'" +
            ", facilities='" + getFacilities() + "'" +
            "}";
    }
}
