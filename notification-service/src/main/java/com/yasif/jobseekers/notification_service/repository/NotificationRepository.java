package com.yasif.jobseekers.notification_service.repository;

import com.yasif.jobseekers.notification_service.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
