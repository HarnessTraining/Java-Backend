package com.virtusa.pgrental.dao;

import com.virtusa.pgrental.model.User;
import com.virtusa.pgrental.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Method to add a new user to the database
    public boolean addUser(User user) {
        String query = "INSERT INTO users (uname, upwd, uemail, umobile) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getMobile());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to retrieve a user by email
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE uemail = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setName(resultSet.getString("uname"));
                    user.setPassword(resultSet.getString("upwd"));
                    user.setEmail(resultSet.getString("uemail"));
                    user.setMobile(resultSet.getString("umobile"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Other methods for updating, deleting, and retrieving users can be added here
}
