package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private BigDecimal amount;
    private Timestamp transactionDate;
    private String paymentMethod;
    private String status;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
