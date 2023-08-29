package Agile.demo.Controller;

import Agile.demo.Entities.Notification;
import Agile.demo.Entities.Task;
import Agile.demo.Service.NotifService;
import Agile.demo.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifs")
public class NotificationController {
    @Autowired
    private NotifService notifService;
    @Autowired
    private TaskService taskService;
    @PostMapping("/save")
    public void createNotification(@PathVariable String content) {
        notifService.createNotification(content);
    }
    @GetMapping("/all")
    public List<Notification> getUnreadNotifications() {
        return notifService.getUnreadNotifications();
    }
    @PostMapping("/{notificationId}/mark-as-read")
    public void markNotificationAsRead(@PathVariable Long notificationId) {
        notifService.markNotificationAsRead(notificationId);
    }
    @PostMapping("/tasknotif")
    public void createTaskNotification(Task task, String action) {
        notifService.createTaskNotification(task, action);
    }
}
