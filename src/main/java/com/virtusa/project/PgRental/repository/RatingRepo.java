package com.virtusa.project.PgRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.project.PgRental.model.Rating;

public interface RatingRepo extends JpaRepository<Rating, Long> {

    List<Rating> findByUserUserId(Long userId);
}
