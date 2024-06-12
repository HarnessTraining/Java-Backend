package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.UserDTO;
import com.virtusa.project.PgRental.model.User;
import com.virtusa.project.PgRental.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User updatedUser = getUser(userDTO, optionalUser);
            updatedUser = userRepository.save(updatedUser);
            return modelMapper.map(updatedUser, UserDTO.class);
        } else {
            throw new RuntimeException("User not found with id " + userId);
        }
    }

    private static User getUser(UserDTO userDTO, Optional<User> optionalUser) {
        User updatedUser = optionalUser.get();
        updatedUser.setUserName(userDTO.getUserName());
        updatedUser.setEmail(userDTO.getEmail());
        updatedUser.setPassword(userDTO.getPassword());
        updatedUser.setPhoneNumber(userDTO.getPhoneNumber());
        updatedUser.setAdmin(userDTO.isAdmin());
        updatedUser.setAdminVerified(userDTO.isAdminVerified());
        updatedUser.setHasProperty(userDTO.isHasProperty());
        updatedUser.setReferralCode(userDTO.getReferralCode());
        updatedUser.setReferralDiscount(userDTO.getReferralDiscount());
        return updatedUser;
    }

    // Other methods like deleteUser, getAllUsers, getUserById, getUserByUserName
    // will be implemented similarly
}
