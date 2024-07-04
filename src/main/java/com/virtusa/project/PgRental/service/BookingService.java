package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.BookingDto;

import java.util.List;




public interface BookingService {
    BookingDto createBooking(BookingDto bookingDto);
    void updateBooking(BookingDto bookingDto);
    BookingDto getBookingDetails(long bookingId);
    void deleteBooking(long bookingId);
    List<BookingDto> getAllBookings();
    List<BookingDto> getBookingsByUserId(Long userId);
    void savePaymentTransaction(Long bookingId, String paymentId) throws Exception;
}
