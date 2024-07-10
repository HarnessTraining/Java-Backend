package com.virtusa.project.PgRental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.project.PgRental.dao.RatingDao;
import com.virtusa.project.PgRental.dto.RatingDto;
import com.virtusa.project.PgRental.model.Rating;
import com.virtusa.project.PgRental.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingDao ratingDao;

    @Override
    public void createReview(RatingDto ratingDto) {
        ratingDao.saveReview(ratingDto);
    }

    @Override
    public void updateReview(Long id, RatingDto ratingDto) {
        ratingDao.updateReview(id, ratingDto);
    }

    @Override
    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingDao.getRatingsByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByPropertyId(Long propertyId) {
        return ratingDao.getRatingsByPropertyId(propertyId); // Add this method
    }
}
