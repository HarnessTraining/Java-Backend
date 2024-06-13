package com.virtusa.project.PgRental.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.project.PgRental.model.User;


public interface UserRepository extends JpaRepository<User,Long> {

     
}
