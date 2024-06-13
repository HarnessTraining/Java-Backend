package com.virtusa.project.PgRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private long bookingId;
    private boolean isPgBooking;
    private Timestamp bookingTime;
    private Date startDate;
    private Date endDate;
    private Date nextPaymentDate;
    private boolean isConfirmed;
    private String referralCodeUsed;
    private BigDecimal securityDeposit;
    private boolean isRefunded;
    private long userId;
    private long propertyId;
    private long roomId;
    private List<Long> paymentTransactionIds;
}
