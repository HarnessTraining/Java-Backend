package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.dto.UserDTO;
import com.virtusa.project.PgRental.model.User;
import com.virtusa.project.PgRental.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(u -> modelMapper.map(u, UserDTO.class));
//        if (user.isPresent()) {
//            return Optional.of(modelMapper.map(user.get(), UserDTO.class));
//        }
//        return Optional.empty();
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            // Encode the password before saving
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            User updatedUser = modelMapper.map(userDTO, User.class);
            updatedUser.setUserId(id); // Ensure the ID is set correctly
            updatedUser = userRepository.save(updatedUser);

            return modelMapper.map(updatedUser, UserDTO.class);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    public UserDTO getUserByUserName(String userName) {
        return modelMapper.map(this.userRepository.findByUserName(userName),UserDTO.class);
    }
}
