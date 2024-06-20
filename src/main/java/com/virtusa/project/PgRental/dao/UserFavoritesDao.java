package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.model.Property;
import com.virtusa.project.PgRental.model.Rating;
import com.virtusa.project.PgRental.model.UserFavorites;
import com.virtusa.project.PgRental.repository.PropertyRepo;
import com.virtusa.project.PgRental.repository.UserFavoriteRepo;
import com.virtusa.project.PgRental.repository.UserRepo;

import com.virtusa.project.PgRental.dto.UserFavoritesDto;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserFavoritesDao {

    @Autowired
    private UserFavoriteRepo userFavoriteRepo;

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private UserRepo userRepo;

    private ModelMapper modelMapper = new ModelMapper();

    public void saveUserFavorites(UserFavoritesDto userFavoritesDto) {
        UserFavorites userFavorites = modelMapper.map(userFavoritesDto, UserFavorites.class);
        userFavoriteRepo.save(userFavorites);
    }

    public boolean deleteUserFavorites(Long propertyId,Long userId) {
        // UserFavorites userFavorites = userFavoriteRepo.findById(userId).orElse(null);
        // userFavoriteRepo.delete(userFavorites);
        Optional<UserFavorites> favorite = userFavoriteRepo.findByUserIdAndPropertyId(userId, propertyId);
        if (favorite.isPresent()) {
            userFavoriteRepo.deleteByUserIdAndPropertyId(userId, propertyId);
            return true;
        } else {
            return false;
        }
    }

    public Optional<UserFavorites> getRatingsByUserId(Long userId) {
        return userFavoriteRepo.findById(userId);
    }

}
