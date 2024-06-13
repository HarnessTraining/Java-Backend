package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.BookingDto;
import com.virtusa.project.PgRental.model.CustomUserDetails;
import com.virtusa.project.PgRental.service.BookingService;
import com.virtusa.project.PgRental.service.CustomUserDetailsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping
    public ResponseEntity<Void> createBooking(@RequestBody BookingDto bookingDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomUserDetails userDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername(username);
        bookingDto.setUserId(userDetails.getUserId());

        if (bookingDto.getBookingTime() == null) {
            bookingDto.setBookingTime(new Timestamp(System.currentTimeMillis()));
        }
        if (bookingDto.getStartDate() != null && bookingDto.getNextPaymentDate() == null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(bookingDto.getStartDate());
            cal.add(Calendar.DAY_OF_MONTH, 31);
            bookingDto.setNextPaymentDate(cal.getTime());
        }
        
        bookingService.createBooking(bookingDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBooking(@PathVariable long id, @RequestBody BookingDto bookingDto) {
        bookingDto.setBookingId(id);
        bookingService.updateBooking(bookingDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingDetails(@PathVariable long id) {
        BookingDto bookingDto = bookingService.getBookingDetails(id);
        if (bookingDto != null) {
            return ResponseEntity.ok(bookingDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        List<BookingDto> bookingDtoList = bookingService.getAllBookings();
        return ResponseEntity.ok(bookingDtoList);
    }
}
