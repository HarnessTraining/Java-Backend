package com.virtusa.project.PgRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.project.PgRental.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
    User findByUserName(String userName);
    User findByEmail(String email);
}
