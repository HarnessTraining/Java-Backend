package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.NotificationsDTO;
import com.virtusa.project.PgRental.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {
    @Autowired
    private NotificationsService notificationsService;

    @PostMapping
    public ResponseEntity<NotificationsDTO> createNotification(@RequestBody NotificationsDTO notificationsDTO) {
        NotificationsDTO createdNotification = notificationsService.createNotification(notificationsDTO);
        return ResponseEntity.ok(createdNotification);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationsDTO>> getNotificationsByUserId(@PathVariable Long userId) {
        List<NotificationsDTO> notifications = notificationsService.getNotificationsByUserId(userId);
        return ResponseEntity.ok(notifications);
    }

    @PutMapping("/{notificationId}/read")
    public ResponseEntity<Void> markAsRead(@PathVariable Long notificationId) {
        notificationsService.markAsRead(notificationId);
        return ResponseEntity.ok().build();
    }
}
