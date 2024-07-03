package com.virtusa.project.PgRental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class PaymentTransactions {
    @Id
    private String paymentId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

}
