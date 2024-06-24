package com.virtusa.project.PgRental.service.impl;

import com.virtusa.project.PgRental.dao.NotificationsDao;
import com.virtusa.project.PgRental.dto.NotificationsDTO;
import com.virtusa.project.PgRental.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsServiceImpl implements NotificationsService {

    @Autowired
    private NotificationsDao notificationsDao;


    @Override
    public NotificationsDTO createNotification(NotificationsDTO notificationsDTO){
        return notificationsDao.createNotification(notificationsDTO);
    }
    @Override
    public List<NotificationsDTO> getNotificationsByUserId(Long userId) {
        return notificationsDao.getNotificationsByUserId(userId);
    }

    @Override
    public void markAsRead(Long notificationId) {
        notificationsDao.markAsRead(notificationId);
    }

}
