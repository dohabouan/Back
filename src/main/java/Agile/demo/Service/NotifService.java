package Agile.demo.Service;

import Agile.demo.Entities.Notification;
import Agile.demo.Entities.Task;
import Agile.demo.Repository.NotifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotifService {
    @Autowired
    private NotifRepository notificationRepository;

    public void createNotification(String content) {
        Notification notification = new Notification();
        notification.setContent(content);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRead(false);

        notificationRepository.save(notification);
    }

    public List<Notification> getUnreadNotifications() {
        return notificationRepository.findByReadFalseOrderByCreatedAtDesc();
    }

    public void markNotificationAsRead(Long notificationId) {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        optionalNotification.ifPresent(notification -> {
            notification.setRead(true);
            notificationRepository.save(notification);
        });
    }
    public void createTaskNotification(Task task, String action) {
        String notificationContent = "La tâche " + task.getDescription() + " a été " + action + ".";
        createNotification(notificationContent);
    }
}

