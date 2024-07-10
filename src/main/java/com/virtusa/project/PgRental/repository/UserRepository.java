package com.virtusa.project.PgRental.repository;

import com.virtusa.project.PgRental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);
    Optional<User> findByPhoneNumber(String phoneNumber);
    List<User> findByAdminVerified(boolean adminVerified);
    Optional<User> findByReferralCode(String referralCode);

}
