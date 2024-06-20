package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.BookingDto;

import java.util.List;




public interface BookingService {
    void createBooking(BookingDto bookingDto);
    void updateBooking(BookingDto bookingDto);
    BookingDto getBookingDetails(long bookingId);
    void deleteBooking(long bookingId);
    List<BookingDto> getAllBookings();
}
