package com.virtusa.project.PgRental.repository;

import com.virtusa.project.PgRental.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notifications,Long> {
    List<Notifications> findByUserUserId(Long userId);
}
