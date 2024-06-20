package com.virtusa.project.PgRental.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.project.PgRental.dao.UserFavoritesDao;
import com.virtusa.project.PgRental.dto.UserFavoritesDto;
import com.virtusa.project.PgRental.model.Property;
import com.virtusa.project.PgRental.model.UserFavorites;
import com.virtusa.project.PgRental.repository.UserFavoriteRepo;
import com.virtusa.project.PgRental.service.UserFavoriteService;

@Service
public class UserFavoritesServiceImpl implements UserFavoriteService {

    
   
    // private final UserFavoriteRepo userFavoriteRepo;
    
    @Autowired
    private UserFavoritesDao userFavoritesDao;

    @Override
    public void saveUserFavorites(UserFavoritesDto userFavoritesDto) {
        userFavoritesDao.saveUserFavorites(userFavoritesDto);
    }

    @Override
    public boolean deleteUserFavorites(Long propertyId,Long userId) {
        return userFavoritesDao.deleteUserFavorites(propertyId,userId);
    }

    @Override
    public Optional<UserFavorites> getFavoriteProperty(Long favoriteId) {
        return userFavoritesDao.getRatingsByUserId(favoriteId);

    }

    // @Override
    // public long countFavoritePropertiesByUserId(Long userId) {
    //     return userFavoriteRepo.countByUserId(userId);
    // }

    


}