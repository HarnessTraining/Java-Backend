package com.virtusa.project.PgRental.repository;

import com.virtusa.project.PgRental.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
