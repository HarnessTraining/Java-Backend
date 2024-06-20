package com.virtusa.project.PgRental.service;


import com.virtusa.project.PgRental.dao.UserDao;
import com.virtusa.project.PgRental.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
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
        UserDTO userDTO = getUserById(userId).orElseThrow(() -> new Exception("User not found"));
        userDTO.setAdminVerified(true);
        return updateUser(userId, userDTO);
    }

    @Override
    public void disapproveUser(Long userId) throws Exception {
        deleteUser(userId);
    }

}
