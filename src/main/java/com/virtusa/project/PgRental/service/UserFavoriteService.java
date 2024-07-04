package com.virtusa.project.PgRental.service;

import java.util.List;
import java.util.Optional;

import com.virtusa.project.PgRental.dto.RoomDto;
import com.virtusa.project.PgRental.dto.UserFavoritesDto;
import com.virtusa.project.PgRental.model.Property;
import com.virtusa.project.PgRental.model.Rating;
import com.virtusa.project.PgRental.model.UserFavorites;

public interface UserFavoriteService {
    public void saveUserFavorites(UserFavoritesDto userFavoritesDto);
    public boolean deleteUserFavorites(Long propertyId,Long userId);  
    List<UserFavoritesDto> getFavoriteProperty(Long userId);
    // long countFavoritePropertiesByUserId(Long userId);
}
