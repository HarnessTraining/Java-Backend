package com.virtusa.project.PgRental.dao;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.virtusa.project.PgRental.dto.RatingDto;
import com.virtusa.project.PgRental.model.Rating;
import com.virtusa.project.PgRental.repository.PropertyRepo;
import com.virtusa.project.PgRental.repository.RatingRepo;
import com.virtusa.project.PgRental.repository.UserRepo;

@Repository
public class RatingDao {

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RatingRepo ratingRepo;

    private ModelMapper modelMapper;

    @Autowired
    public RatingDao(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(new PropertyMap<RatingDto, Rating>() {
            @Override
            protected void configure() {
                skip(destination.getRatingId()); // Skip mapping for the primary key
                skip(destination.getUser()); // Skip mapping for user
                skip(destination.getProperty()); // Skip mapping for property
            }
        });
    }

    public void saveReview(RatingDto ratingDto) {
        Rating rating = modelMapper.map(ratingDto, Rating.class);
        rating.setUser(userRepo.findById(ratingDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found")));
        rating.setProperty(propertyRepo.findById(ratingDto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found")));
        ratingRepo.save(rating);
    }

    public void updateReview(Long id, RatingDto ratingDto) {
        Rating rating = ratingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found"));

        rating.setRating(ratingDto.getRating());
        rating.setDescription(ratingDto.getDescription());
        rating.setUser(userRepo.findById(ratingDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found")));
        rating.setProperty(propertyRepo.findById(ratingDto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found")));

        ratingRepo.save(rating);
    }

    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepo.findByUserUserId(userId);
    }

    public List<Rating> getRatingsByPropertyId(Long propertyId) {
        return ratingRepo.findByPropertyPropertyId(propertyId); // Add this method
    }

    public PropertyRepo getPropertyRepo() {
        return propertyRepo;
    }

    public void setPropertyRepo(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public RatingRepo getRatingRepo() {
        return ratingRepo;
    }

    public void setRatingRepo(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
