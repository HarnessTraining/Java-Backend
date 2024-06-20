package com.virtusa.project.PgRental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.virtusa.project.PgRental.dto.RatingDto;
import com.virtusa.project.PgRental.model.Rating;
import com.virtusa.project.PgRental.service.RatingService;

@RestController
@RequestMapping("/myRating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Void> createReview(@RequestBody RatingDto ratingDto) {
        ratingService.createReview(ratingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReview(@PathVariable Long id, @RequestBody RatingDto ratingDto) {
        ratingService.updateReview(id, ratingDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Long userId) {
        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        return ResponseEntity.ok(ratings);
    }
}
