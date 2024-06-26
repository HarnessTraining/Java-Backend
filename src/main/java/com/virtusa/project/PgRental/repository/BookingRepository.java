package com.virtusa.project.PgRental.repository;

import com.virtusa.project.PgRental.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUser_userId(Long userId);
}
