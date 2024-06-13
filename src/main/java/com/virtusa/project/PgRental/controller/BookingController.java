package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.BookingDto;
import com.virtusa.project.PgRental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Void> createBooking(@RequestBody BookingDto bookingDto) {
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
