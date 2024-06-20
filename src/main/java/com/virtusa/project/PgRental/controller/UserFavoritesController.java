package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.UserFavoritesDto;
import com.virtusa.project.PgRental.model.Property;
import com.virtusa.project.PgRental.model.UserFavorites;
import com.virtusa.project.PgRental.service.UserFavoriteService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-favorite")
public class UserFavoritesController {

    @Autowired
    private UserFavoriteService userFavoritesService;

    @PostMapping
    public ResponseEntity<Void> saveUserFavorites(@RequestBody UserFavoritesDto userFavoritesDto) {
        userFavoritesService.saveUserFavorites(userFavoritesDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public Optional<UserFavorites> countFavoritePropertiesByUserId(@PathVariable Long userId) {
        return userFavoritesService.getFavoriteProperty(userId);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserFavorites(@RequestBody UserFavoritesDto userFavoritesDto ) {
        System.out.println(userFavoritesDto);
        userFavoritesService.deleteUserFavorites(userFavoritesDto.getPropertyId(),userFavoritesDto.getUserId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // @DeleteMapping("/{userId}")
    // public ResponseEntity<String> deletePropertyByUserId(@PathVariable Long userId) {
    //     boolean isDeleted = userFavoritesService.deleteUserFavorites(userId);
    //     if (isDeleted) {
    //         return ResponseEntity.ok("Properties deleted successfully");
    //     } else {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No properties found for this user");
    //     }
    // }
}