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
import java.util.stream.Collectors;

@Service
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO createUser(UserDTO userDTO) throws Exception {
        Optional<User> existingUserByEmail=userRepository.findByEmail(userDTO.getEmail());
        if (existingUserByEmail.isPresent()) {
            throw new Exception("Email is already in use");
        }
        Optional<User> existingUserByUserName = userRepository.findByUserName(userDTO.getUserName());
        if (existingUserByUserName.isPresent()) {
            throw new Exception("Username is already in use");
        }
        Optional<User> existingUserByPhone = userRepository.findByPhoneNumber(userDTO.getPhoneNumber());
        if (existingUserByPhone.isPresent()) {
            throw new Exception("Phone Number is already in use");
        }

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
    public UserDTO updateUser1(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setAdminVerified(true);
            userRepository.save(user);
            return modelMapper.map(user, UserDTO.class);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setPhoneNumber(userDTO.getPhoneNumber());
            User updatedUser = userRepository.save(existingUser);
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
        // System.out.println(userName);
        return modelMapper.map(userRepository.findByUserName(userName).get(),UserDTO.class);
    }

    public List<UserDTO> findUnapprovedUsers() {
        List<User> unapprovedUser = userRepository.findByAdminVerified(false);
        return unapprovedUser.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public List<UserDTO> findapprovedUsers() {
        List<User> approvedUser = userRepository.findByAdminVerified(true);
        return approvedUser.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }


    public UserDTO updateHasBooking(UserDTO userDTO) {
        User user = userRepository.save(modelMapper.map(userDTO,User.class));
        return modelMapper.map(user,UserDTO.class);
    }

    public int getUserByReferralCode(String referralCode) throws Exception {
        Optional<User> user = userRepository.findByReferralCode(referralCode);
        if(user.isEmpty()){
            throw new Exception("Referral doesn't exist");
        }
        return user.get().getReferralDiscount();
    }
}
