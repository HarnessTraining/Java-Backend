package com.virtusa.project.PgRental.service.impl;

import com.virtusa.project.PgRental.dao.BookingDao;
import com.virtusa.project.PgRental.dto.BookingDto;
import com.virtusa.project.PgRental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        return bookingDao.createBooking(bookingDto);
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




    @Override
    public void savePaymentTransaction(Long bookingId, String paymentId) throws Exception {
        bookingDao.savePaymentTransaction(bookingId, paymentId);
    }

    @Override
    public List<BookingDto> getBookingsByPropertyId(Long propertyId) {
        return bookingDao.getBookingsByPropertyId(propertyId);
    }

}
