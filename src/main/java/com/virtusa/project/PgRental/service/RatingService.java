package com.virtusa.project.PgRental.service;

import java.util.List;

import com.virtusa.project.PgRental.dto.RatingDto;
import com.virtusa.project.PgRental.model.Rating;

public interface RatingService {
    void createReview(RatingDto ratingDto);
    void updateReview(Long id, RatingDto ratingDto);
    List<Rating> getRatingsByUserId(Long userId);
}
