package com.virtusa.project.PgRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PgFacilitiesDto {
    private long pgFacilitiesId;
    private BigDecimal cost;
    private Date startDate;
    private Date endDate;
    private PropertyDto property;
    private FacilitiesDto facilities;

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

    public PropertyDto getProperty() {
        return property;
    }

    public void setProperty(PropertyDto property) {
        this.property = property;
    }

    public FacilitiesDto getFacilities() {
        return facilities;
    }

    public void setFacilities(FacilitiesDto facilities) {
        this.facilities = facilities;
    }
}
