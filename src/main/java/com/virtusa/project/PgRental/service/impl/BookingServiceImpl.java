package com.virtusa.project.PgRental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.project.PgRental.dao.BookingDao;
import com.virtusa.project.PgRental.dto.BookingDto;
import com.virtusa.project.PgRental.service.BookingService;


@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
    private BookingDao bookingDao;

    @Override
    public void createBooking(BookingDto bookingDto) {
        bookingDao.createBooking(bookingDto);
    }

    @Override
    public void updateBooking(BookingDto bookingDto) {
        bookingDao.updateBooking(bookingDto);
    }

    @Override
    public BookingDto getBookingDetails(long bookingId) {
        return bookingDao.getBookingDetails(bookingId);
    }

    @Override
    public void deleteBooking(long bookingId) {
        bookingDao.deleteBooking(bookingId);
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingDao.getAllBookings();
    }

    @Override
    public List<BookingDto> getBookingsByUserId(Long userId) {
        return bookingDao.getBookingsByUserId(userId);
    }
    
}
