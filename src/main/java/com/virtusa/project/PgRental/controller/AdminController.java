package com.virtusa.project.PgRental.controller;



import com.virtusa.project.PgRental.dto.BookingDto;
import com.virtusa.project.PgRental.dto.PropertyDto;
import com.virtusa.project.PgRental.dto.UserDTO;
import com.virtusa.project.PgRental.service.BookingService;
import com.virtusa.project.PgRental.service.PropertyService;
import com.virtusa.project.PgRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        PropertyDto propertyDto = propertyService.getPropertyById(propertyId);
        PropertyDto approvedProperty = propertyService.approveProperty(propertyDto);
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


    @GetMapping("/Allbookings/")
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        List<BookingDto> bookingDtoList = bookingService.getAllBookings();
        return ResponseEntity.ok(bookingDtoList);
    }

    @GetMapping("/unapproved-properties")
    public ResponseEntity<List<PropertyDto>> getUnapprovedProperties() {
        List<PropertyDto> unapprovedProperties = propertyService.getUnapprovedProperties();
        return ResponseEntity.ok(unapprovedProperties);
    }
    @GetMapping("/unapproved-users")
    public ResponseEntity<List<UserDTO>> getUnapprovedUsers() {
        List<UserDTO> unapprovedUsers = userService.getUnapprovedUsers();
        return ResponseEntity.ok(unapprovedUsers);
    }

    @PutMapping("/update-bookings/{Id}")
    public ResponseEntity<Void> updateBooking(@PathVariable long id, @RequestBody BookingDto bookingDto) {
        bookingDto.setBookingId(id);
        bookingService.updateBooking(bookingDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete-bookings/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/approved-users")
    public ResponseEntity<List<UserDTO>> getApprovedUsers() {
        List<UserDTO> approvedUsers = userService.getApprovedUsers();
        return ResponseEntity.ok(approvedUsers);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

