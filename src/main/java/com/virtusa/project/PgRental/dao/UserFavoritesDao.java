package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.model.Property;
import com.virtusa.project.PgRental.model.Rating;
import com.virtusa.project.PgRental.model.User;
import com.virtusa.project.PgRental.model.UserFavorites;
import com.virtusa.project.PgRental.repository.PropertyRepo;
import com.virtusa.project.PgRental.repository.PropertyRepository;
import com.virtusa.project.PgRental.repository.UserFavoriteRepo;
import com.virtusa.project.PgRental.repository.UserRepo;
import com.virtusa.project.PgRental.repository.UserRepository;
import com.virtusa.project.PgRental.dto.PropertyDto;
import com.virtusa.project.PgRental.dto.UserDTO;
import com.virtusa.project.PgRental.dto.UserFavoritesDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserFavoritesDao {

    @Autowired
    private UserFavoriteRepo userFavoriteRepo;
    
    private ModelMapper modelMapper = new ModelMapper();

    public void saveUserFavorites(UserFavoritesDto userFavoritesDto) {
        UserFavorites userFavorites = modelMapper.map(userFavoritesDto, UserFavorites.class);
        userFavoriteRepo.save(userFavorites);
    }

    public boolean deleteUserFavorites(Long propertyId, Long userId) {
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

    public List<UserFavoritesDto> getFavoritesByUserId(Long userId) {
        List<UserFavorites> userFavorites = userFavoriteRepo.findAllByUser(userId);

        Set<Long> seenPropertyIds = new HashSet<>();

        return userFavorites.stream()
        .filter(favorite -> seenPropertyIds.add(favorite.getProperty().getPropertyId())) // Add to set and filter out duplicates
        .map(favorite -> modelMapper.map(favorite, UserFavoritesDto.class))
        .collect(Collectors.toList());
    }
}
