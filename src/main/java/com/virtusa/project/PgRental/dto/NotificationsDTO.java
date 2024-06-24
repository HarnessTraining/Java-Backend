package com.virtusa.project.PgRental.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NotificationsDTO {
    private long notificationId;
    private String message;
    private boolean isRead;
    private Timestamp notificationDate;
    private Long userId; // User ID to associate with the notification
}
