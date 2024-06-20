package com.virtusa.project.PgRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransactionsDto {
    private long transactionId;
    private BigDecimal amount;
    private Timestamp transactionDate;
    private String paymentMethod;
    private String status;
    private long bookingId;
}


