package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.dto.NotificationsDTO;
import com.virtusa.project.PgRental.model.Notifications;
import com.virtusa.project.PgRental.repository.NotificationsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class NotificationsDao {

    @Autowired
    private NotificationsRepository notificationsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public NotificationsDTO createNotification(NotificationsDTO notificationsDTO) {
        Notifications notifications = modelMapper.map(notificationsDTO,Notifications.class);
        notifications = notificationsRepository.save(notifications);
        return modelMapper.map(notifications,NotificationsDTO.class);
    }

    public List<NotificationsDTO> getNotificationsByUserId(Long userId) {
        List<Notifications> notificationsList = notificationsRepository.findByUserUserId(userId);
        return notificationsList.stream().map(notification -> modelMapper.map(notification,NotificationsDTO.class))
                .collect(Collectors.toList());
    }

    public void markAsRead(Long notificationId) {
        Optional<Notifications> notificationsOptional = notificationsRepository.findById(notificationId);
        if (notificationsOptional.isPresent()) {
            Notifications notifications = notificationsOptional.get();
            notifications.setRead(true);
            notificationsRepository.save(notifications);
        } else {
            throw new RuntimeException("Notification not found with id " + notificationId);
        }
    }
}
