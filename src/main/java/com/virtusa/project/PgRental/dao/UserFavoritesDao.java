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
    private PropertyRepository propertyRepository;
    @Autowired
    private UserRepository userRepository;

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
        List<UserFavoritesDto> listDto = new ArrayList<>();
        List<UserFavorites> list = userFavoriteRepo.findAllByUser(userId);

        for (UserFavorites e : list) {
            UserFavoritesDto userFavoritesDto = new UserFavoritesDto();
            userFavoritesDto.setFavoriteId(e.getFavoriteId());

            Property property = propertyRepository.findById(e.getProperty().getPropertyId()).orElse(null);
            if (property != null) {
                PropertyDto propertyDto = modelMapper.map(property, PropertyDto.class);
                userFavoritesDto.setProperty(propertyDto);
            }
            // else {
            // // Handle the case where the property is not found

            // continue;
            // }

            User user = userRepository.findById(e.getUser().getUserId()).orElse(null);
            if (user != null) {
                userFavoritesDto.setUserId(user.getUserId());
            }
            // else {
            // // Handle the case where the user is not found
            // continue;
            // }

            listDto.add(userFavoritesDto);
        }

        return listDto;
    }

}
