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

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public boolean isPgBooking() {
        return isPgBooking;
    }

    public void setPgBooking(boolean pgBooking) {
        isPgBooking = pgBooking;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Timestamp bookingTime) {
        this.bookingTime = bookingTime;
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

    public Date getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(Date nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getReferralCodeUsed() {
        return referralCodeUsed;
    }

    public void setReferralCodeUsed(String referralCodeUsed) {
        this.referralCodeUsed = referralCodeUsed;
    }

    public BigDecimal getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(BigDecimal securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public boolean isRefunded() {
        return isRefunded;
    }

    public void setRefunded(boolean refunded) {
        isRefunded = refunded;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public List<Long> getPaymentTransactionIds() {
        return paymentTransactionIds;
    }

    public void setPaymentTransactionIds(List<Long> paymentTransactionIds) {
        this.paymentTransactionIds = paymentTransactionIds;
    }
}
