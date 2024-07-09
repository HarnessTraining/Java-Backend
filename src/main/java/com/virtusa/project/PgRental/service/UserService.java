package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public UserDTO createUser(UserDTO userDTO) throws Exception;

    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    public UserDTO getUserByUserName(String userName);

    UserDTO approveUser(Long userId) throws Exception;
    void disapproveUser(Long userId) throws Exception;
    List<UserDTO> getUnapprovedUsers();
    List<UserDTO> getApprovedUsers();

    UserDTO updatehasBooking(UserDTO userDTO1);

    int getUserByReferralCode(String referralCode) throws Exception;


//    UserDTO updateUser(Long id, UserDTO userDTO);
//
//    void deleteUser(Long id);
//
//    Collection<Object> getAllUsers();
}
