package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.NotificationsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationsService {
    NotificationsDTO createNotification(NotificationsDTO notificationsDTO);
    List<NotificationsDTO> getNotificationsByUserId(Long userId);

    void markAsRead(Long notificationId);
}
