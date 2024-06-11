package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "propertyId")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.REMOVE)
    private List<PaymentTransactions> paymentTransactions;

}
