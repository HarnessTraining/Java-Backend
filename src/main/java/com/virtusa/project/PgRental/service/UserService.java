package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

//    UserDTO updateUser(Long id, UserDTO userDTO);
//
//    void deleteUser(Long id);
//
//    Collection<Object> getAllUsers();
}
