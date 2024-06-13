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
    private long propertyId;
    private long facilityId;
}
