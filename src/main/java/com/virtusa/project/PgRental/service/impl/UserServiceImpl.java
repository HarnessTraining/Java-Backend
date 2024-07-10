package com.virtusa.project.PgRental.service.impl;


import com.virtusa.project.PgRental.dao.UserDao;
import com.virtusa.project.PgRental.dto.UserDTO;
import com.virtusa.project.PgRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDTO createUser(UserDTO userDTO) throws Exception {
        return userDao.createUser(userDTO);
    }

    @Override
    public List<UserDTO> getAllUsers(){
        return userDao.getAllUsers();
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return userDao.updateUser(id, userDTO);
    }

    @Override
    public void deleteUser(Long id){
        userDao.deleteUser(id);
    }

    @Override
    public UserDTO getUserByUserName(String userName){
        return userDao.getUserByUserName(userName);
    }

    @Override
    public UserDTO approveUser(Long userId) throws Exception {
        return userDao.updateUser1(userId);
    }

    @Override
    public void disapproveUser(Long userId) throws Exception {
        userDao.deleteUser(userId);
    }
    @Override
    public List<UserDTO> getUnapprovedUsers() {
        return userDao.findUnapprovedUsers();
    }

    @Override
    public List<UserDTO> getApprovedUsers() {
        return userDao.findapprovedUsers();
    }

    @Override
    public UserDTO updatehasBooking(UserDTO userDTO1) {
        return userDao.updateHasBooking(userDTO1);
    }

    @Override
    public int getUserByReferralCode(String referralCode) throws Exception {
        return userDao.getUserByReferralCode(referralCode);
    }

}
