package com.virtusa.project.PgRental.controller;



import com.virtusa.project.PgRental.dto.BookingDto;
import com.virtusa.project.PgRental.dto.PropertyDto;
import com.virtusa.project.PgRental.dto.UserDTO;
import com.virtusa.project.PgRental.service.BookingService;
import com.virtusa.project.PgRental.service.PropertyService;
import com.virtusa.project.PgRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @PutMapping("/approve-property/{propertyId}")
    public ResponseEntity<PropertyDto> approveProperty(@PathVariable Long propertyId) throws Exception {
        PropertyDto approvedProperty = propertyService.approveProperty(propertyId);
        return ResponseEntity.ok(approvedProperty);
    }

    @DeleteMapping("/disapprove-property/{propertyId}")
    public ResponseEntity<Void> disapproveProperty(@PathVariable Long propertyId) throws Exception {
        propertyService.disapproveProperty(propertyId);
        return ResponseEntity.noContent().build();
    }

    // Assuming similar methods for user approval and disapproval
    @PutMapping("/approve-user/{userId}")
    public ResponseEntity<UserDTO> approveUser(@PathVariable Long userId) throws Exception {
        UserDTO approvedUser = userService.approveUser(userId);
        return ResponseEntity.ok(approvedUser);
    }

    @DeleteMapping("/disapprove-user/{userId}")
    public ResponseEntity<Void> disapproveUser(@PathVariable Long userId) throws Exception {
        userService.disapproveUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/bookings/{userId}")
    public ResponseEntity<List<BookingDto>> getBookingsByUserId(@PathVariable Long userId) {
        List<BookingDto> bookingsByUser = bookingService.getBookingsByUserId(userId);
        return ResponseEntity.ok(bookingsByUser);
    }
}

